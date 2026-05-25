import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Employee {
    private final String id;
    private final String name;
    private String jobTitle;
    private double salary;
    private LocalDate dateOfEmployment;

    private Employee(String id, String name, String jobTitle, double salary, LocalDate dateOfEmployment){
        this.id = id;
        this.name = name;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.dateOfEmployment = dateOfEmployment;
    }

    public static Employee createEmployee(String id, String name, String jobTitle, double salary, LocalDate dateOfEmployment){
        if(id == null || id.isBlank()) return null;
        if(name == null || name.isBlank()) return null;
        if(jobTitle == null || jobTitle.isBlank()) return null;
        if(salary <= 0) return null;
        if(dateOfEmployment.isBefore(LocalDate.now())) return null;
        return new Employee(id, name, jobTitle, salary, dateOfEmployment);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", salary=" + salary +
                ", dateOfEmployment=" + dateOfEmployment +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(!(obj instanceof  Employee employeeCompared)) return false;
        return  employeeCompared.getId().equals(id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, jobTitle, salary, dateOfEmployment);
    }

    public double getYearsOfService(){
        return (double) Period.between(dateOfEmployment, LocalDate.now()).getMonths() /12;
    }

    public double calculateBonus(){
        int years =  (int) getYearsOfService();
        return years*0.1*salary;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDateOfEmployment(LocalDate dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }
}
