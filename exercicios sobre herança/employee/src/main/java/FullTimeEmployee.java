import java.time.LocalDate;

public final class FullTimeEmployee extends Employee{
    private double monthSalary;

    private FullTimeEmployee(String id, String name, String jobTitle, LocalDate dateOfEmployment, double monthSalary) {
        super(id, name, jobTitle, dateOfEmployment);
        this.monthSalary = monthSalary;
    }

    public static FullTimeEmployee createFullTimeEmployee(String id, String name, String jobTitle, LocalDate dateOfEmployment, double monthSalary){
        if(id == null || id.isBlank()) return null;
        if(name == null || name.isBlank()) return  null;
        if(jobTitle == null || jobTitle.isBlank()) return null;
        if(dateOfEmployment.isBefore(LocalDate.now())) return null;
        return new FullTimeEmployee(id, name, jobTitle, dateOfEmployment, monthSalary);
    }

    @Override
    public double salary() {
        return monthSalary;
    }

    @Override
    public String toString() {
        return super.toString() + " month salary: " + monthSalary;
    }

    public void setMonthSalary(double monthSalary) {
        if(monthSalary > this.monthSalary && monthSalary > 0) {
            this.monthSalary = monthSalary;
        }
    }
}
