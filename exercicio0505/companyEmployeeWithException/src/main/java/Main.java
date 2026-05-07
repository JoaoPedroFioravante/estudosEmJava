import java.time.LocalDate;

public class Main {
    static void main() {
        //system.out ao inves do system.err para ficar na ordem no terminal
        CompanyRepository repository = new CompanyFakeRepository();
        CompanyService company = new CompanyService(repository);
        System.out.println("================contratação==============");
        try {
            company.hire("01", "a1", "servidor", 2500, LocalDate.of(2022, 5, 2));
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        try {
            company.hire("02", "a2", "servidor", 2500, LocalDate.of(2023, 5, 2));
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        try {
            company.hire("03", "a3", "servidor", 2500, LocalDate.of(2024, 5, 2));
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        try {
            company.hire("04", "a4", "servidor", 2500, LocalDate.of(2025, 5, 2));
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        try {
            company.hire("05", "a5", "chefe", 3500, LocalDate.of(2022, 5, 2));
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        try {
            company.hire("06", "a6", "coordenador", 3200);
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        try {
            company.hire(null, "a6", "coordenador", 3200);
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        System.out.println("==================pagamento==================");
        try {
            company.payToTest("01", LocalDate.now());
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        try {
            company.payToTest("02", LocalDate.of(2026, 3, 10));
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        try {
            company.payToTest("03", LocalDate.of(2026, 3, 11));
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        try {
            company.payToTest("04", LocalDate.of(2026, 3, 12));
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        try {
            company.payToTest("06", LocalDate.of(2026, 3, 12));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        try {
            company.payToTest("05", LocalDate.of(2026, 3, 13));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("=================estatisticas=================");
        try {
            System.out.println(company
                    .averageSalary(LocalDate.of(2026, 3, 11),
                            LocalDate.of(2026, 3, 12)));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(company.averageSalary("servidor"));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        try{
            System.out.println(company.averageSalary("        "));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("===================demitindo==================");
        try{
            company.fire(null);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        try {
            company.fire("01");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("======================exibindo todos funcionarios==============");
        company.iteratorOfAllEmployees().forEachRemaining(System.out::println);
        System.out.println();
        try{
            company.iteratorOfEmployeesThatHaveSame("servidor").forEachRemaining(System.out::println);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        try{
            company.iteratorOfEmployeesThatHaveSame("ser").forEachRemaining(System.out::println);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("============================aumento de salario=========================");
        try {
            company.increaseSalary("01", 2000);
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        try {
            company.increaseSalary("02", 2000);
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        try {
            company.increaseSalary("02", 3000);
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
}
