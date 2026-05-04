package classesEinterface;

import java.time.LocalDate;
import java.util.Iterator;

//TODO não entendi muito o sentido de colocar Inteface Genérica nesse caso
//TODO em Java não coloque I no início de Interfaces. Isso é usado em C#, mas não em Java.
public interface ICompany<T, I, S> {
    //coloquei 3 porque o tipo do jobtitle pode ser enum(situação ficticia)
    void hire(T object);
    void fire(T object);
    Iterator<Employee> getAll();
    Iterator<Employee> getAllOf(S jobTitle);
    void pay(I id);
    void increaseSalary(I id, Double newSalary);
    Double averageSalaryOf(S jobtitle);
    Double averageSalaryBetween(LocalDate initial, LocalDate end);
}
