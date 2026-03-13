public class Team {
    private String name, baseLocation, coachName;
    private Player[] players = new Player[18];
    private Player captain;
    private int qtdPlayers = 0, inField = 0, outField = 0;

    public Team(){}

    public Team(String name, String baseLocation, String coachName){
        this.name = name;
        this.baseLocation = baseLocation;
        this.coachName = coachName;
    }

    public void setBaseLocation(String baseLocation){
        this.baseLocation = baseLocation;
    }

    public String getBaseLocation(){
        return this.baseLocation;
    }

    public String getName(){
        return name;
    }

    public void addPlayer(Player player){
        if(player.getField() && inField < 11) inField++;
        else{
            if(player.getField()){
                player.setField(false);
            }
            outField++;
        }
        player.setTeamPlayer(this);
        players[qtdPlayers++] = player;
    }

    public void removePlayer(Player player){
        int index = searchPlayer(player);
        if(index!=-1) {
            if (player.getField()) {
                int i = searchOutField();
                if (i != -1) {
                    players[i].setField(true);
                    outField--;
                } else {
                    inField--;
                }
            } else {
                outField--;
            }
            arrayRemove(index);
            qtdPlayers--;
            player.setTeamPlayer(null);
        }
    }

    private void arrayRemove(int index){
        for(int i = index; i<qtdPlayers-1; i++){
            players[i] = players[i+1];
        }
    }

    private int searchPlayer(Player player){
        if(player.getTeamPlayer() == this){
            for(int  i = 0; i<qtdPlayers; i++){
                if(player.equals(players[i])){
                    return i;
                }
            }
        }
        return -1;
    }

    private int searchOutField(){
        for(int i = 0; i<qtdPlayers; i++){
            if(!players[i].getField()){
                return i;
            }
        }
        return -1;
    }

    public void substitute(Player outField, Player inField){
        if((!outField.getField()) && inField.getField()){
            outField.setField(true);
            inField.setField(false);
        }
    }

    public void setCaptain(Player player){
        captain = player;
    }

    public String getCaptain(){
        return captain.getStateAsString();
    }

    public String getCoachName(){
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public Player[] getFieldPlayer(){
        Player[] x = new Player[inField];
        int c = 0;
        for(int i = 0; i<qtdPlayers; i++) {
            if(players[i].getField()) x[c++] = players[i];
        }
        return x;
    }

    public Player[] getOutFieldPlayer(){
        Player[] x = new Player[outField];
        int c = 0;
        for(int i = 0; i<qtdPlayers; i++) {
            if(!players[i].getField()) x[c++] = players[i];
        }
        return x;
    }


}
