import java.util.*;

public class CompanyFakeRepository implements CompanyRepository {
    private static final Map<String, Employee> employeeMap = new HashMap<>();

    public CompanyFakeRepository() {}

    @Override
    public void put(Employee e) {
        employeeMap.put(e.getId(), e);
    }

    @Override
    public Employee remove(String id) {
        return employeeMap.remove(id);
    }

    @Override
    public Optional<Employee> findById(String id) {
        return Optional.ofNullable(employeeMap.get(id)); // TODO se o employeeMap.get(id) retornar null, ele vai criar um Optiona.EMPTY (evita null pointer acidental)
    }

    @Override
    public List<Employee> findAll() {
        //TODO CREDO!
//        return employeeMap.values()
//                .stream()
//                .toList();
        return new ArrayList<>(employeeMap.values());
    }

    @Override
    public List<Employee> findByJobTitle(String jobTitle) {
        //TODO aqui sim precisa do stream, porque tem o que fazer com os dados (filtar)
        return employeeMap.values()
                .stream()
                .filter(e->e.getJobTitle().equals(jobTitle))
                .toList();
    }
}
