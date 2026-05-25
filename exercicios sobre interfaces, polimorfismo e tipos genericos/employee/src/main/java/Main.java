import java.time.LocalDate;

public class Main {
    static void main() {
        Repository<Employee, String> repository = new FakeEmployeeRepository();

        RegisterEmployeeService register = new RegisterEmployeeService(repository);
        FindEmployeeService findEmployee = new FindEmployeeService(repository);

        register.register(Employee.createEmployee("123", "joao", "experiencia", 2000, LocalDate.now()));
        register.register(Employee.createEmployee("1223", "pedrao", "experiencia", 3000, LocalDate.now()));
        register.register(Employee.createEmployee("1243", "luizao", "experiencia", 1800, LocalDate.now()));
        register.register(Employee.createEmployee("1263", "lucas", "experiencia", 1500, LocalDate.now()));

        System.out.println(findEmployee.findById("1263"));
        System.out.println(findEmployee.findById("1243"));
        System.out.println(findEmployee.findById("1223"));
        System.out.println(findEmployee.findById("12233"));
    }
}
