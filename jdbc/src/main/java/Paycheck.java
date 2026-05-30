import java.time.LocalDate;
import java.util.Objects;

public class Paycheck {
    private final LocalDate payday;
    private final double salary;
    private final String idEmployee;

    public Paycheck(LocalDate payday, double salary, String idEmployee){
        this.payday = payday;
        this.salary = salary;
        this.idEmployee = idEmployee;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Paycheck paycheck)) return false;
        return Double.compare(salary, paycheck.salary) == 0
                && Objects.equals(payday, paycheck.payday)
                && idEmployee.equals(paycheck.idEmployee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(payday, salary, idEmployee);
    }

    @Override
    public String toString() {
        return "Paycheck: " +
                "payday: " + payday +
                " salary: " + salary +
                " id employee: "+idEmployee;
    }

    public LocalDate getPayday() {
        return payday;
    }

    public double getSalary() {
        return salary;
    }

    public String getIdEmployee() {
        return idEmployee;
    }
}
