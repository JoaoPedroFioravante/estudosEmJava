import java.util.List;

public interface CompanyRepository {
    public void put(Employee e);
    public Employee remove(String id);
    public Employee findById(String id);
    public List<Employee> findAll();
    public List<Employee> findByJobTitle(String jobTitle);
}
