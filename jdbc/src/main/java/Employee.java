import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Employee {
    private final String id;
    private final String name;
    private String JobTitle;
    private double salary;
    private final int idCompany;
    private final LocalDate dateOfEmployment;
    private final List<Paycheck> paychecks;


    public Employee(String id, String name, double salary, LocalDate dateOfEmployment, String jobTitle, int idCompany) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.dateOfEmployment = dateOfEmployment;
        this.idCompany = idCompany;
        this.paychecks = new ArrayList<>();
        JobTitle = jobTitle;
    }

    public double getYearsOfService(){
     return (double) Period.between(dateOfEmployment, LocalDate.now()).getMonths()/12;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Employee employee)) return false;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", JobTitle='" + JobTitle + '\'' +
                ", salary=" + salary +
                ", dateOfEmployment=" + dateOfEmployment +
                ", id company: "+ idCompany+
                '}';
    }

    public int getIdCompany() {
        return idCompany;
    }

    protected void addPaycheck(LocalDate payday){
        Paycheck paycheck = new Paycheck(payday, salary, id);
        paychecks.add(paycheck);
        AddEntities.addEntityPaycheckOfEmployee(paycheck);
    }
    protected void removePaycheck(Paycheck paycheck){
        if(paycheck == null) return;
        paychecks.remove(paycheck);
        DeleteEntities.deletePaycheck(paycheck.getPayday(), this.id);
    }
    public Iterator<Paycheck> iteratorPaycheck(){
        return paychecks.iterator();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getJobTitle() {
        return JobTitle;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setJobTitle(String jobTitle) {
        if(jobTitle == null || jobTitle.isBlank()) return;
        JobTitle = jobTitle;
        UpdateEntities.updateEmploye(this);
    }

    protected void increaseSalary(double salary) {
        this.salary = salary;
    }

}
