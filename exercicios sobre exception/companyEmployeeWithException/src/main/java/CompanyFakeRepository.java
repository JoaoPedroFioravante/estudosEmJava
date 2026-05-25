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
    public Employee findById(String id) {
        return employeeMap.get(id);
    }

    @Override
    public List<Employee> findAll() {
        return employeeMap.values()
                .stream()
                .toList();
    }

    @Override
    public List<Employee> findByJobTitle(String jobTitle) {
        return employeeMap.values()
                .stream()
                .filter(e->e.getJobTitle().equals(jobTitle))
                .toList();
    }
}
