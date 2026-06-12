package services;

import model.Player;
import model.PlayerDTO;
import model.Team;
import model.TeamDTO;
import persistence.DAO;
import persistence.TeamDAO;

import java.util.Objects;
import java.util.Optional;

public class GetTeamService {
    private final TeamDAO<TeamDTO, String, PlayerDTO> teamDAO;

    public GetTeamService(TeamDAO<TeamDTO, String, PlayerDTO> teamDAO ) {
        this.teamDAO = teamDAO;
    }

    public Optional<Team> getTeam(String key){
        Objects.requireNonNull(key, "id/nome do time não pode ser nulo");
        if(key.isBlank())
            throw new IllegalArgumentException("id/nome não estar vazio");
        var team = teamDAO.findByKey(key);
        if(team.isEmpty()) return Optional.empty();
        if(team.get().captain() == null){
            return Optional.of(new Team(
                    team.get().name(),
                    team.get().baseLocation(),
                    team.get().coachName(),
                   null));
        }
        var captainDTO = team.get().captain();
        var captain = new Player(
                captainDTO.id(),
                captainDTO.name(),
                captainDTO.position(),
                captainDTO.number(),
                captainDTO.isFielded(),
                captainDTO.team()
                );
        return Optional.of(new Team(
                team.get().name(),
                team.get().baseLocation(),
                team.get().coachName(),
                captain));
    }
}
