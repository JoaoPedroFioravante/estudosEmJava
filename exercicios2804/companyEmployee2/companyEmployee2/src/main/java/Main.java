import java.time.LocalDate;

public class Main {
    static void main() {
        Company company = new Company("testeCompany");
        //todo contratando
        company.hire("01", "e1", 2000, LocalDate.of(2025, 2, 1), "engenheiro");
        company.hire("02", "e2", 2500, LocalDate.of(2025, 6,7), "engenheiro");
        company.hire("03", "e3", 2600, LocalDate.of(2025, 12, 29),"engenheiro");
        company.hire("04", "e4", 2700, LocalDate.of(2025, 8,2), "engenheiro");
        company.hire("05", "e5", 2900, LocalDate.now(), "engenheiro");
        company.hire("06", "e6", 2800, LocalDate.now(), "engenheiro");
        company.hire("07", "e7", 8000,LocalDate.now(), "supervisor");
        company.hire("08", "e8", 4000, LocalDate.now(), "supervisor");

        //todo medias de salarios
        System.out.printf("media de salario dos trabalhadores que são supervisores: %.2f \n",
                company.averageSalaryByJobTitle("supervisor"));
        //add paychecks
        company.payToTestByDate("01", LocalDate.of(2026, 4, 2));
        company.payToTestByDate("02", LocalDate.of(2026, 4, 3));
        company.payToTestByDate("03", LocalDate.of(2026, 4, 4));
        company.payToTestByDate("04", LocalDate.of(2026, 5, 3));
        company.payToTestByDate("05", LocalDate.of(2026, 5, 4));
        company.increaseSalary("06", 4000);
        company.payToTestByDate("06", LocalDate.of(2026, 4, 4));

        System.out.printf("media dos salarios entre as datas 03/04/2026 a 03/05/2026: %.2f \n",
                company.averageSalary(LocalDate.of(2026, 4, 3), LocalDate.of(2026, 5, 3)));

        var allEmployees = company.iteratorOfAllEmployees();
        System.out.println("all employees of company");
        allEmployees.forEachRemaining(e -> System.out.println(e.getName()));

        System.out.println("all employees of jobTitle equals supervisor");
        var supervisores = company.iteratorOfEmployeesWithJobTitle("supervisor");
        supervisores.forEachRemaining(e -> System.out.println(e.getName()));

        //todo fire e1 e3
        company.fire("01");
        company.fire("03");
        System.out.println("company after fired employees of id: 01 and 03");
        allEmployees = company.iteratorOfAllEmployees();
        allEmployees.forEachRemaining(e -> System.out.println(e.getName()));
    }
}
