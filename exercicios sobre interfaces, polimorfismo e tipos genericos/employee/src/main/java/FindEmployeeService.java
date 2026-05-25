public class FindEmployeeService {
    //TODO perfeito, aqui você inverte a dependência. Ao invés de depender de um banco
    // específico, depende de uma interface que você controla. Ela define o contrato
    // que a classe que acessa o banco vai seguir. Logo, o detalhe depende da regra, não o contrário.
    private final Repository<Employee, String> repository; //final porque não muda depois.

    //TODO perfeito. Aqui é injeção da dependência
    public FindEmployeeService(Repository<Employee, String> repository){
        this.repository = repository;
    }

    public Employee findById(String id){
        if(id == null || id.isBlank()) return null;
        return repository.findById(id);
    }
}
