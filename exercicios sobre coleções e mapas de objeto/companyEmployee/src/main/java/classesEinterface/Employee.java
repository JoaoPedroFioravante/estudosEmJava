package classesEinterface;

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
    private final LocalDate dateOfEmployment;
    private final List<Paycheck> paychecks;

    private Employee(String id, String name, double salary, LocalDate dateOfEmployment) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.dateOfEmployment = dateOfEmployment;
        this.paychecks = new ArrayList<>();
        this.JobTitle = "temp";
    }

    private Employee(String id, String name, double salary, LocalDate dateOfEmployment, String jobTitle) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.dateOfEmployment = dateOfEmployment;
        this.paychecks = new ArrayList<>();
        JobTitle = jobTitle;
    }

    public static Employee createEmployee(String id, String name, double salary, LocalDate dateOfEmployment){
        if(id == null || id.isBlank()) return null;
        if(name == null || name.isBlank()) return null;
        if(salary <= 0) return  null;
        //if(dateOfEmployment.isBefore(LocalDate.now())) return null;
        return new Employee(id, name, salary, dateOfEmployment);
    }

    public static Employee createEmployee(String id, String name, double salary, LocalDate dateOfEmployment, String jobTitle){
        if(id == null || id.isBlank()) return null;
        if(name == null || name.isBlank()) return null;
        if(jobTitle == null || jobTitle.isBlank()) return null;
        if(salary <= 0) return  null;
        //if(dateOfEmployment.isBefore(LocalDate.now())) return null; desativei para testes
        return new Employee(id, name, salary, dateOfEmployment, jobTitle);
    }

    public double getYearsOfService(){
     return (double) Period.between(dateOfEmployment, LocalDate.now()).getMonths()/12;
    }
    protected void addPaycheck(LocalDate payday){
        paychecks.add(new Paycheck(payday, salary));
    }
    protected void removePaycheck(Paycheck paycheck){
        if(paycheck == null) return;
        paychecks.remove(paycheck);
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
    }

    //TODO como o salário só aumenta, o melhor nome seria increaseSalary mesmo. Nem sempre precisa chamar set ...
    protected void setSalary(double salary) {
        if(salary <= this.salary) return;
        this.salary = salary;
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
                '}';
    }
}
