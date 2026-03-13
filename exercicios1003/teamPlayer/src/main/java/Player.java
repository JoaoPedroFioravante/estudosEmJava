public class Player {
    private String position, name;
    private int number;
    private boolean isFielded;
    private Team team;



    public Player(String name, String position, int number, boolean isFielded){
        this.name = name;
        this.position = position;
        this.number = number;
        this.isFielded = isFielded;

    }

    public void setTeamPlayer(Team team){
        this.team = team;
    }

    public Team getTeamPlayer(){
        return team;
    }

    public void setField(boolean state){
        this.isFielded = state;
    }

    public boolean getField(){
        return this.isFielded;
    }


    public String getStateAsString(){
        return String.format("%s %s %s %d %b", name, position, team.getName(), number, isFielded);
    }
}
