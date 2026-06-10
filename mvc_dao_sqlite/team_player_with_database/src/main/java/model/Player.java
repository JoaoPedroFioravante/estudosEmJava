package model;

import java.util.Objects;

public class Player {
    private final int id;
    private String position;
    private String name;
    private int number;
    private boolean isFielded;
    private Team team;

    public Player(int id, String name, String position, int number, boolean isFielded) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.number = number;
        this.isFielded = isFielded;
    }

    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if (o == null ) return false;
        if(!(o instanceof Player player)) return false;
        return id == player.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "player: "+
                "id: " + id +
                " position: " + position  +
                " name: " + name +
                " number: " + number +
                " isFielded: " + isFielded +
                " team: " + team;
    }

    public int getId() {
        return id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isFielded() {
        return isFielded;
    }

    public void setFielded(boolean fielded) {
        isFielded = fielded;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}