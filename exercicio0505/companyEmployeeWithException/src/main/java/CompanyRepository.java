import java.util.List;
import java.util.Optional;

public interface CompanyRepository {
    public void put(Employee e); //TODO sem público, todo método de interface por padrão é nulo.
    public Employee remove(String id);
    public Optional<Employee> findById(String id);// TODO evita null pointer se não achar ninguém para a chave.
    public List<Employee> findAll();
    public List<Employee> findByJobTitle(String jobTitle);
}
