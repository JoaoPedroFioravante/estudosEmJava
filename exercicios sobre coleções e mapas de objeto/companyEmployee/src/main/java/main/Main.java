package main;
import classesEinterface.ICompany;
import classesEinterface.Employee;
import classesEinterface.CompanyEmployeesService;
import classesEinterface.Paycheck;
import classesEinterface.Company;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
public class Main {
    static void main() {
        Employee e1 = Employee.createEmployee("01", "e1", 2000, LocalDate.of(2025, 2, 1));
        Employee e2 = Employee.createEmployee("02", "e2", 2500, LocalDate.of(2025, 6,7));
        Employee e3 = Employee.createEmployee("03", "e3", 2600, LocalDate.of(2025, 12, 29));
        Employee e4 = Employee.createEmployee("04", "e4", 2700, LocalDate.of(2025, 8,2));
        Employee e5 = Employee.createEmployee("05", "e5", 2900, LocalDate.now());
        Employee e6 = Employee.createEmployee("06", "e6", 2800, LocalDate.now());
        Employee e7 = Employee.createEmployee("07", "e7", 8000,LocalDate.now(), "supervisor");
        Employee e8 = Employee.createEmployee("08", "e8", 4000, LocalDate.now(), "supervisor");
        List<Employee> employees = List.of(e1, e2, e3, e4, e5, e6, e7, e8);
        ICompany<Employee, String, String> implementation = new CompanyEmployeesService();
        Company empresa = new Company("xxx", implementation);
        for(var employee: employees){
            empresa.hire(employee);
        }
        System.out.println("=====================todos funcionarios===================");
        Iterator<Employee> employeeIterator= empresa.getEmployees();
        while(employeeIterator.hasNext()){
            Employee emp = employeeIterator.next();
            System.out.println(emp);
        }
        System.out.println("====================apenas supervisores====================");
        employeeIterator = empresa.getEmployees("supervisor");
        employeeIterator.forEachRemaining(e -> System.out.println(e));
        System.out.println("====================media salarial por job title=============");
        double averageSupervisor = empresa.averageSalary("supervisor");
        System.out.println("media salarial = "+averageSupervisor);
        System.out.println("====================media por data inicio e fim==============");
        double averageOfdates = empresa.averageSalary(LocalDate.of(2025, 6, 2),LocalDate.of(2025, 12, 30));
        System.out.println("media salarial = "+averageOfdates);
        empresa.pay("01");
        var iterator = e1.iteratorPaycheck();
        System.out.println("paycheck 01");
        iterator.forEachRemaining(i-> System.out.println(i));
        System.out.println("fire 01 e 03 e percurso ");
        empresa.fire(e1);
        empresa.fire(e3);
        employeeIterator = empresa.getEmployees();
        employeeIterator.forEachRemaining(e-> System.out.println(e));
        System.out.println("increase salary employe 4 para 5000");
        System.out.println("salario atual: "+e4.getSalary());
        empresa.increaeSalary("04", 5000);
        System.out.println("salario novo: "+e4.getSalary());
    }
}
