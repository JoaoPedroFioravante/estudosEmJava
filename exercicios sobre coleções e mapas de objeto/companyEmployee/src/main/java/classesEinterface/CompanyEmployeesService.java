package classesEinterface;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompanyEmployeesService implements ICompany<Employee, String, String>{
    private final List<Employee> employees; // TODO isso é um atributo que deveria estar em Company, usando um map pela chave (id) de employee.

    public CompanyEmployeesService(){
        this.employees = new ArrayList<>();
    }

    @Override
    public void hire(Employee employee) {
       // if(employees.stream().anyMatch(employee::equals)) return; //TODO cuidado com o overengineering
        if(employees.contains(employee)) return;
        employees.add(employee);
    }

    @Override
    public void fire(Employee employee) {
        employees.remove(employee);
    }

    @Override
    public Iterator<Employee> getAll() { // TODO employeesIterator (é comum o método que retorna iterator informar que o retorno é um iterator)
        if(employees.isEmpty()) return null; // TODO evite retornar nulo. É melhor retornar iterator para vazio. Evita nullpointer.
        return employees.iterator();
    }

    @Override
    public Iterator<Employee> getAllOf(String jobTitle) {
        return employees.stream()
                .filter(e -> e.getJobTitle().equals(jobTitle))
                .toList()
                .iterator();
    }

    @Override
    public void pay(String id) {
        //TODO se o employee tivesse vindo de um repository, faria sentido colocar aqui, na forma como está fazendo.
        //TODO como não temos banco, nesse caso, coloca dentro do Company.
        Employee employee =  employees.stream()
                .filter(e -> e.getId().equals(id))
                .findAny()
                .orElse(null);
        if(employee == null) return;
        employee.addPaycheck(LocalDate.now());
    }

    @Override
    public void increaseSalary(String id, Double newSalary) {
        Employee employee = employees.stream()
                .filter(e -> e.getId().equals(id))
                .findAny()
                .orElse(null);
        if(employee == null) return;
        employee.setSalary(newSalary);
    }

    @Override
    public Double averageSalaryOf(String jobtitle) {
        return employees.stream()
                .filter(e -> e.getJobTitle().equals(jobtitle))
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(-1); //média de nada é ZERO e não -1.
    }

    //interpretei como data de contratação. TODO Nops, as datas são as dos pagamentos (paychecks). Esse precisa pensar um poquinho mais.
    @Override
    public Double averageSalaryBetween(LocalDate initial, LocalDate end) {
        return employees.stream()
                // TODO O que você quer fazer? (A || B) && C ou A || (B && C) ?  ANDs podem ser divididos em filters consecutivos para melhorar a clareza
                .filter(e ->  e.getDateOfEmployment().isEqual(initial) || e.getDateOfEmployment().isAfter(initial) && e.getDateOfEmployment().isBefore(end))
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(-1);// 0
    }
}
