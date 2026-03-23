import java.time.LocalDate;

public class Post {
    private String quote;
    private LocalDate date;
    private int claps = 0, boos = 0;
    private UserAccount user;

    public void Post(UserAccount account, String quote){
        if(account != null && !quote.isBlank()){
            user = account;
            this.quote = quote;
            date = LocalDate.now();
        }
    }

    public String Show(){
        //utilizei stringBuilder só por desempenho porque podia ser string concatenada
        StringBuilder string = new StringBuilder();
        string.append("[");
        string.append(date);
        string.append("] ");
        string.append(user.getUserName());
        string.append(" says ");
        string.append(quote);
        string.append(" / Claps: ");
        string.append(claps);
        string.append(" / Boos: ");
        string.append(boos);
        return string.toString();
    }

    public void clap(){
        claps++;
    }
    //pensei em colocar setclap e setboo mas deixei o que a UML descreve
    public void boo(){
        boos++;
    }

    public LocalDate getDate(){
        return date;
    }

}
