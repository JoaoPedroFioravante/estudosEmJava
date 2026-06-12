package model;

import java.util.Objects;

public class Team {
    private final String name;
    private String baseLocation;
    private String coachName;
    private Player captain;

    public Team(String name, String baseLocation, String coachName){
        this.name = name;
        this.baseLocation = baseLocation;
        this.coachName = coachName;
        captain = null;
    }

    public Team(String name, String baseLocation, String coachName, Player captain){
        this.name = name;
        this.baseLocation = baseLocation;
        this.coachName = coachName;
        this.captain = captain;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(name, team.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "team: " +
                "name: " + name  +
                " baseLocation: " + baseLocation +
                " coachName: " + coachName +
                " captain: " + captain;
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

    public void setCaptain(Player player){
        captain = player;
    }

    public Player getCaptain(){
        return captain;
    }

    public String getCoachName(){
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

}
