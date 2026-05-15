import java.time.LocalDate;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class CompanyService {
    private final CompanyRepository repository;

    public CompanyService(CompanyRepository repository) {
        this.repository = repository;
    }

    //TODO note o espaçamento vertical que coloquei, para melhorar legibilidade.
    public void hire(String id, String name, String jobTitle, double salary, LocalDate dateOfEmployment) {
        requireNonNullAndIsBlank(name, "nome");
        requireNonNullAndIsBlank(jobTitle, "titulo de cargo");
        Objects.requireNonNull(dateOfEmployment, "data de contratação não pode ser nulo");

        requireNonNullAndIsBlank(id, "id");
        if (repository.findById(id) != null) throw new IllegalArgumentException("funcionario já cadastrado");

        if (salary <= 0) throw new IllegalArgumentException("salario não pode ser menor ou igual a 0");

        Employee employee = new Employee(id, name, jobTitle, salary, dateOfEmployment);
        Objects.requireNonNull(employee, "não foi possivel adicionar o funcionario"); // TODO isso aqui não faz sentido.

        repository.put(employee);
    }

    public void hire(String id, String name, String jobTitle, double salary) {
        hire(id, name, jobTitle, salary, LocalDate.now());
    }

    //TODO ninguém usa, porque não usar somente o de cima, com todos os args?
    public void hire(String id, String name, double salary, LocalDate dateOfEmployment) {
        hire(id, name, "temp", salary, dateOfEmployment);
    }

    //TODO idem.
    public void hire(String id, String name, double salary) {
        hire(id, name, "temp", salary, LocalDate.now());
    }

    private void requireNonNullAndIsBlank(String variable, String variableName) {
        Objects.requireNonNull(variable, variableName + " não pode ser nulo");
        if (variable.isBlank()) {
            throw new IllegalArgumentException(variableName + " não pode estar vazio");
        }
    }

    public void fire(String id) {
        requireNonNullAndIsBlank(id, "id");
        if (repository.remove(id) == null) {
            throw new IllegalArgumentException("id recebido não está cadastrado");
        }

    }

    public Iterator<Employee> iteratorOfAllEmployees() {
        return repository.findAll().iterator();
    }

    public Iterator<Employee> iteratorOfEmployeesThatHaveSame(String jobTitle) {
        requireNonNullAndIsBlank(jobTitle, "titulo de cargo");
        return repository.findByJobTitle(jobTitle).iterator();
    }

    public void pay(String id) {
        //TODO com optional e declarativo
//        requireNonNullAndIsBlank(id, "id");
//        Employee employee = repository.findById(id);
//        if(employee == null){
//            throw new IllegalArgumentException("id recebido não está cadastrado");
//        }
//        employee.addPaycheck(LocalDate.now());
        payToTest(id, LocalDate.now());
    }

    public void payToTest(String id, LocalDate date) {
        //TODO com optional e declarativo
        repository.findById(id).ifPresentOrElse(
                e -> e.addPaycheck(LocalDate.now()),
                () -> {throw new NoSuchElementException("User not found: " + id);}
        );
    }

    public void increaseSalary(String id, double newSalary) {
//        requireNonNullAndIsBlank(id, "id");
//        Employee employee = repository.findById(id);
//        if (employee == null) {
//            throw new IllegalArgumentException("id recebido não está cadastrado na base de dados");
//        }
//        employee.increaseSalary(newSalary);
        repository.findById(id).ifPresentOrElse(
                e -> e.increaseSalary(newSalary),
                () -> {throw new NoSuchElementException("User not found: " + id);}
        );
    }

    public double averageSalary(String jobTitle) {
        requireNonNullAndIsBlank(jobTitle, "titulo de cargo");
        return repository.findByJobTitle(jobTitle)
                .stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);
    }

    public double averageSalary(LocalDate initial, LocalDate end) {
//        Objects.requireNonNull(initial, "data inicial não pode ser nula");
//        Objects.requireNonNull(end, "data final não pode ser nula");
//        if (initial.isAfter(end))
//            throw new IllegalArgumentException("data inicial: " + initial + " não pode ser depois da data final: " + end);
//        var iteratorOfPaychecks = repository.findAll().stream().map(Employee::iteratorPaycheck).toList();
//        double media = 0;
//        double quantidade = 0;
//        for (int i = 0; i < iteratorOfPaychecks.size(); i++) {
//            var iterator = iteratorOfPaychecks.get(i);
//            while (iterator.hasNext()) {
//                Paycheck paycheck = iterator.next();
//                if (!(paycheck.getPayday().isBefore(initial) || paycheck.getPayday().isAfter(end))) {
//                    media += paycheck.getSalary();
//                    quantidade++;
//                }
//            }
//        }
//        return quantidade == 0 ? 0 : Math.round(media / quantidade);
        //TODO e Deus fez a Stream API e viu que era bom. No sétimo dia, ele descansou.
        return repository.findAll().stream()
                .flatMap(e -> e.getPaychecks().stream())// junta todos paychecks de todo mundo em um único stream de paychecks
                .filter(p -> !p.getPayday().isBefore(initial)) // maior-igual é igual a "não menor"
                .filter(p -> p.getPayday().isAfter(end)) //menor-igual é igual a "não maior"
                .mapToDouble(Paycheck::getSalary)
                .average().orElse(0.0);

        //TODO do caralho, não?
    }
}
