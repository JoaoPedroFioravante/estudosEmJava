package model;

public record TeamDTO(String name,
        String baseLocation,
        String coachName,
        PlayerDTO captain) {
    public static TeamDTO toDTO(Team team){
        if(team == null)
            return null;
        var captain = team.getCaptain();
        return new TeamDTO(team.getName(),
                team.getBaseLocation(),
                team.getCoachName(),
                PlayerDTO.toDTO(captain)
                );
    }
}
