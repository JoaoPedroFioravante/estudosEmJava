import java.time.LocalDate;
import java.time.Period;

public class Pessoa {
    private LocalDate birthDate;
    private String name;
    private String fone;

    public Pessoa(LocalDate birthDate, String name, String fone) {
        this.birthDate = birthDate;
        this.name = name;
        this.fone = fone;
    }

    public int getAge(){
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    private void calling(String name){
        System.out.println("calling to "+name+ ".... calling ....");
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }
}
