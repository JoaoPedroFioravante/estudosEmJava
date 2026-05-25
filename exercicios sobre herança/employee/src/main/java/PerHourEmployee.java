import java.time.LocalDate;

public final class PerHourEmployee extends Employee{
    private double hourlyRate;
    private double workedHour;

    private PerHourEmployee(String id, String name, String jobTitle, LocalDate dateOfEmployment, double hourlyRate, double workedHour) {
        super(id, name, jobTitle, dateOfEmployment);
        this.hourlyRate = hourlyRate;
        this.workedHour = workedHour;
    }

    public static PerHourEmployee createPerHourEmployee(String id, String name, String jobTitle, LocalDate dateOfEmployment, double hourlyRate, double workedHour){
        if(id == null || id.isBlank()) return null;
        if(name == null || name.isBlank()) return null;
        if(jobTitle == null || jobTitle.isBlank()) return null;
        if(dateOfEmployment.isBefore(LocalDate.now()))return  null;
        if(hourlyRate <= 0) return null;
        if (workedHour < 0) return null;
        return new PerHourEmployee(id, name, jobTitle, dateOfEmployment, hourlyRate, workedHour);
    }

    @Override
    public double salary() {
        return hourlyRate*workedHour;
    }

    @Override
    public String toString() {
        return super.toString()+ "hourly rate: "+ hourlyRate+ " worked hour: "+ workedHour;
    }

    public void  setHourlyRate(double hourlyRate){
        if(hourlyRate > 0 && this.hourlyRate < hourlyRate) {
            this.hourlyRate = hourlyRate;
        }
    }

    public void setWorkedHour(double workedHour){
        if(workedHour >= 0){
            this.workedHour+= workedHour;
        }
    }

    public void resetWorkedHour(){
        workedHour = 0;
    }
}
