public class RegisterEmployeeService {
    private final Repository<Employee, String> repository;

    public RegisterEmployeeService(Repository<Employee, String> repository){
        this.repository = repository;
    }

    public boolean register(Employee employee){
        //TODO aqui parece "bobeira", porque praticamente não faz nada e só redireciona o código para
        // outra classe. Mas, em métodos reais, é aqui que você coloca a regra de negócio. O repo
        // só representa o banco, sem fazer nada. É tipo banco.salvar(coisa).
        if(employee == null) return false;
        return repository.register(employee);
    }
}
