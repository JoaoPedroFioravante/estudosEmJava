import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static java.time.Period.between;

public class Employee {
    private final String id;
    private final String name;
    private String jobTitle;
    private double salary;
    private final LocalDate dateOfEmployment;
    private final List<Paycheck> paychecks;

    public Employee(String id, String name, String jobTitle, double salary, LocalDate dateOfEmployment){
        this.id = id;
        this.name = name;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.dateOfEmployment = dateOfEmployment;
        paychecks = new ArrayList<>();
    }

    public double getYearsOfService(){
        return (double)Period.between(dateOfEmployment, LocalDate.now()).getMonths()/12;
    }

    //+ addPaycheck(payday: LocalDate): void
    public void addPaycheck(LocalDate payday){
        Objects.requireNonNull(payday, "data do holerite não pode estar nula");
        Paycheck paycheck = new Paycheck(payday, salary);
        Objects.requireNonNull(paycheck, "não foi possivel adicionar paycheck"); // TODO essa linha não faz sentido, você só deve ver nulidade de parametros. Aqui você acabou de dar new.
        paychecks.add(paycheck);
    }

    public void removePaycheck(Paycheck paycheck){
        paychecks.remove(paycheck);
    }

    public Iterator<Paycheck> iteratorPaycheck(){
        return paychecks.iterator();
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
        return "Employee:" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", salary=" + salary +
                ", dateOfEmployment=" + dateOfEmployment +
                ", paychecks=" + paychecks
                ;
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

    public List<Paycheck> getPaychecks() {
        return new ArrayList<>(paychecks);
    }

    public void setJobTitle(String jobTitle) {
        Objects.requireNonNull(jobTitle, "jobTitle nao pode ser nulo");
        if(jobTitle.isBlank()){
            throw new IllegalArgumentException("jobTitle nao pode estar vazio");
        }
        this.jobTitle = jobTitle;
    }

    public double getSalary() {
        return salary;
    }

    public void increaseSalary(double salary) {
        if(this.salary >= salary) throw new IllegalArgumentException("novo salario do id: "+id+" deve ser maior que o salario atual: "+ this.salary);
        this.salary = salary;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }
}
