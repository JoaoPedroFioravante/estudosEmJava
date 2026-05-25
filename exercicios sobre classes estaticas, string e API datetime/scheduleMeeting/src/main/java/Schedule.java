import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class Schedule {
    private final LocalDate day;
    private final LocalTime startTime, endTime;
    private Meeting[] meetings = new Meeting[20];
    private int meetingsIndex = 0;

    //TODO os comentários de Meeting também valem aqui
    public static Schedule createSchedule(LocalDate day, LocalTime startTime, LocalTime endTime){
        if(startTime.isBefore(endTime)){
            return new Schedule(day, startTime, endTime);
        }
        return null;
    }

    public static Schedule createSchedule(LocalTime startTime, LocalTime endTime){
        LocalDate today = LocalDate.now();
        return  createSchedule(today, startTime, endTime);
    }

    private Schedule(LocalDate day, LocalTime startTime, LocalTime endTime){
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void addMeeting(Meeting meeting){
        // TODO desenhe as duas linhas do tempo no papel, dá para simplificar isso com duas partes só + isValidMeeting
        // TODO quebre as guard clauses em ifs separados (primeiro um que retorna se for fora do expediente e outra se
        //  colide com algum meeting já existente. Isso melhora a legibilidade.
        if(meeting.getStartTime().isAfter(startTime) && meeting.getEndTime().isBefore(endTime)
                && meeting.getEndTime().isAfter(meeting.getStartTime()) && isMeetingValid(meeting))
        {
            meetings[meetingsIndex++] = meeting;
        }
    }

    // TODO desenhe as duas linhas do tempo no papel, dá para simplificar isso com duas partes só
    private boolean isMeetingValid(Meeting meeting){
        for(int i = 0; i<meetingsIndex; i++){
            if(!(meeting.getEndTime().isBefore(meetings[i].getStartTime()) || meeting.getStartTime().isAfter(meetings[i].getEndTime()))){
                return false;
            }
        }
        return true;
    }

    //TODO como os meets nào estão ordenados, é mais simples colocar o meeting na última posição no lugar do removido
    // e decrementar o contador. E ainda fica O(1) ao invés de O(n) ;)
    public void removeMeeting(Meeting meeting){
        for(int i =0; i<meetingsIndex; i++){
            if(meeting == meetings[i]){
                for(int j = i; j<meetingsIndex-1; j++){
                    meetings[j] = meetings[j+1];
                }
                meetingsIndex--;
                break;
            }
        }
    }

    public double percentageSpentInMeetings(){
        long durationDay = Duration.between(startTime, endTime).toMinutes(), sumMeetingsDuration = 0; // TODO uma declaração por linha por legibilidade.

        for(int i = 0; i<meetingsIndex; i++){
            sumMeetingsDuration += meetings[i].durationInMinutes();
        }
        return (double) (sumMeetingsDuration * 100) /durationDay;
    }

    public String scheduleAsString(){
        StringBuilder schedule = new StringBuilder();
        for(int i = 0; i<meetingsIndex; i++){
            schedule.append(meetings[i].getDescription());
            schedule.append(' ');
            schedule.append(meetings[i].getStartTime().toString());
            schedule.append(' ');
            schedule.append(meetings[i].getEndTime().toString());
            schedule.append("\n");
        }
        return schedule.toString();
    }

}
