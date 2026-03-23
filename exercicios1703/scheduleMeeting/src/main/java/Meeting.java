import java.time.Duration;
import java.time.LocalTime;

public class Meeting {
    private final String description;
    private final LocalTime startTime, endTime;

    public static Meeting createMeeting(String description, LocalTime startTime, LocalTime endTime){
        if(startTime.isBefore(endTime)){ // TODO ou endTime.isAfter(startTime) se quiser que dure ao menos uns milissegundos ;)
            return new Meeting(description, startTime, endTime);
        }
        return null;

        // dê uma lida sobre Object Calisthenics (https://williamdurand.fr/2013/06/03/object-calisthenics/)
        // Em especial, veja sobre Guard Clauses: https://refactoring.guru/replace-nested-conditional-with-guard-clauses
    }

    //TODO construtor antes de métodos com implementação sua.
    private Meeting(String description, LocalTime startTime, LocalTime endTime){
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public long durationInMinutes(){
        return Duration.between(startTime, endTime).toMinutes();
    } //TODO Perfeito.

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime(){
        return endTime;
    }

    public String getDescription(){
        return description;
    }
}
