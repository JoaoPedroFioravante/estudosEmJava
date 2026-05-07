import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Company {
    private final String name;
    private final List<Employee> employeeList;

    public Company(String name){
        this.name = name;
        employeeList = new ArrayList<>();
    }

    public void hire(String id, String name, double salary, LocalDate dateOfEmployment, String jobTitle){
        if(id == null || id.isBlank()) return;
        if(name == null || name.isBlank()) return;
        if(salary <= 0.00) return;
        if(jobTitle == null || jobTitle.isBlank()) return;
        employeeList.add(new Employee(id, name, salary, dateOfEmployment, jobTitle));
    }

    private Employee employeeSearchById(String id){
        if(id == null || id.isBlank()) return null;
        return employeeList.stream().filter(e -> e.getId().equals(id)).findAny().orElse(null);
    }

    public void fire(String id){
        Employee fired = employeeSearchById(id);
        if(fired == null) return;
        employeeList.remove(fired);
    }

    public Iterator<Employee> iteratorOfAllEmployees(){
        return employeeList.iterator();
    }

    public Iterator<Employee> iteratorOfEmployeesWithJobTitle(String jobTitle){
        if(jobTitle == null || jobTitle.isBlank()) return Collections.emptyIterator();
        return employeeList.stream()
                .filter(e -> e.getJobTitle().equals(jobTitle))
                .iterator();
    }

    public void pay (String id){
        Employee employee = employeeSearchById(id);
        if(employee == null) return;
        employee.addPaycheck(LocalDate.now());
    }

    public void payToTestByDate(String id, LocalDate date){
        Employee employee = employeeSearchById(id);
        if(employee == null) return;
        employee.addPaycheck(date);
    }

    public void increaseSalary(String id, double newSalary){
        Employee employee = employeeSearchById(id);
        if(employee == null ) return;
        if(employee.getSalary() >= newSalary) return;
        employee.increaseSalary(newSalary);
    }

    public double averageSalaryByJobTitle(String jobTitle){
        if(jobTitle == null || jobTitle.isBlank()) return 0;
        return employeeList.stream()
                .filter(e -> e.getJobTitle().equals(jobTitle))
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);
    }

    public double averageSalary(LocalDate initialDate, LocalDate endDate){
        // por mais que tenha feito, o que eu fiz foi gambiarra
        if(endDate.isBefore(initialDate)) return 0;
        List<Paycheck> paychecks = new ArrayList<>();
        employeeList
                .forEach(employee -> {
                    var paychecksEmployee = employee.iteratorPaycheck();
                    while (paychecksEmployee.hasNext()){
                        Paycheck paycheck = paychecksEmployee.next();
                        if(!(paycheck.getPayday().isBefore(initialDate) || paycheck.getPayday().isAfter(endDate))){
                            paychecks.add(paycheck);
                            System.out.println(paycheck.getSalary());
                        }
                    }
                });
        return paychecks.stream()
                .mapToDouble(Paycheck::getSalary)
                .average()
                .orElse(0);
    }

    public String getName() {
        return name;
    }
}
