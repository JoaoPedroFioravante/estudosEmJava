public class Player {
    private String position, name;
    private int number;
    private boolean isFielded;
    private Team team;

    //TODO sempre utilize no máximo um espaço em branco, para deixar a classe sem buracos

    public Player(String name, String position, int number, boolean isFielded){
        this.name = name;
        this.position = position;
        this.number = number;
        this.isFielded = isFielded;
        //TODO evite deixar espaços em branco sem razão.
    }

    //TODO deixe os setters e getters sempre no final da classe, após o métodos com lógica sua
    //TODO uma boa sequência é: atributos, construtores, métodos personalizados, setters e getters.
    public void setTeamPlayer(Team team){
        this.team = team;
    }

    //TODO se o atributo é o team, então para garantir padronização, chame o método de setTeam(). Assim, a chamada fica clara: player.setTeam(team). Ou seja, ronaldo.setTeam(real).
    public Team getTeamPlayer(){
        return team;
    }

    public void setField(boolean state){
        this.isFielded = state;
    }

    //TODO quando a variável é booleana, o mais comum é nomear o getter como isFielded(), já que o método responde uma pergunta: "ele está em campo?"
    public boolean getField(){
        return this.isFielded;
    }

    //TODO faltou ao menos getters para position, name e number. Se fizer sentido mudar algo, adicione getters (por exemplo, setPosition() para que ele deixe de ser meia e seja atacante)

    //TODO para melhorar a legibilidade da saída, coloque o nome do atributo e o valor em pares.
    public String getStateAsString(){
        return String.format("%s %s %s %d %b", name, position, team.getName(), number, isFielded);
    }
}
