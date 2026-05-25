import java.time.LocalDate;

public abstract sealed class Employee permits FullTimeEmployee, PerHourEmployee {
    protected final String id;
    protected final String name;
    protected String jobTitle;
    protected final LocalDate dateOfEmployment;

    public Employee(String id, String name, String jobTitle, LocalDate dateOfEmployment){
        this.id = id;
        this.name = name;
        this.jobTitle = jobTitle;
        this.dateOfEmployment = dateOfEmployment;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj ==null) return false;
        if(obj.getClass() != getClass()) return false;
        Employee compared = (Employee) obj;
        return id == compared.getId();
    }

    @Override
    public String toString() {
        return "Employee: " +
                "id= " + id +
                " name= " + name +
                " jobTitle= " + jobTitle +
                " dateOfEmployment= " + dateOfEmployment;
    }

    public void setJobTitle(String jobTitle) {
        if(jobTitle != null && !jobTitle.isBlank()){
            this.jobTitle = jobTitle;
        }
    }

    public abstract double salary();

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }
}
