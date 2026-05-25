import java.time.LocalDate;

public class Main {
    public static void main() {
        FullTimeEmployee fulltime = FullTimeEmployee.createFullTimeEmployee("01", "pedro", "engenheiro", LocalDate.now(), 2200);
        FullTimeEmployee nulltime = FullTimeEmployee.createFullTimeEmployee("02", "joao", "pedreiro de software", LocalDate.of(2026, 4, 14), 1900);
        System.out.println(nulltime);
        System.out.println(fulltime);
        PerHourEmployee perHour = PerHourEmployee.createPerHourEmployee("01", "joao", "analista de sistemas", LocalDate.now(),20, 3 );
        PerHourEmployee perHourequal = PerHourEmployee.createPerHourEmployee("01", "joao", "analista de sistemas", LocalDate.now(),20, 3 );
        PerHourEmployee perHourDiferent = PerHourEmployee.createPerHourEmployee("02", "lucas", "analista de sistemas", LocalDate.now(),20, 6 );
        System.out.println(perHour);
        System.out.println(perHourDiferent);
        System.out.println(perHour.equals(perHourequal));
        System.out.println(perHour.equals(perHourDiferent));
        System.out.println(perHour.salary());

    }
}
