package services;

import model.Player;
import model.PlayerDTO;
import model.Team;
import model.TeamDTO;
import persistence.DAO;
import persistence.TeamDAO;

import java.util.NoSuchElementException;
import java.util.Objects;

public class RemovePlayerTeamService {
    private final TeamDAO<TeamDTO, String, PlayerDTO> teamDAO;
    private final DAO<PlayerDTO, Integer> playerDAO;

    public RemovePlayerTeamService(TeamDAO<TeamDTO, String, PlayerDTO> teamDAO, DAO<PlayerDTO, Integer> playerDAO) {
        this.teamDAO = teamDAO;
        this.playerDAO = playerDAO;
    }

    public void removePlayerOfTeam(String teamKey, int playerKey){
        Objects.requireNonNull(teamKey, "id/nome do time não pode ser nulo");
        if(teamKey.isBlank())
            throw new IllegalArgumentException("id/nome do time não pode estar vazio");
        var teamDTO = teamDAO.findByKey(teamKey);
        if(teamDTO.isEmpty())
            throw new NoSuchElementException("time não existe na base de dados");
        var playerDTO = playerDAO.findByKey(playerKey);
        if(playerDTO.isEmpty())
            throw new NoSuchElementException("player não existe na base de dados");
        if(playerDTO.get().team() == null || !playerDTO.get().team().equals(teamDTO.get().name()))
            throw new NoSuchElementException("player não faz parte do time: "+teamKey);
        if(teamDTO.get().captain().id() != playerDTO.get().id()) {
            playerDAO.update(new PlayerDTO(
                    playerDTO.get().id(),
                    playerDTO.get().position(),
                    playerDTO.get().name(),
                    playerDTO.get().number(),
                    !playerDTO.get().isFielded(),
                    null
            ));
            return;
        }
        Player player = new Player(
                playerDTO.get().id(),
                playerDTO.get().name(),
                playerDTO.get().position(),
                playerDTO.get().number(),
                playerDTO.get().isFielded(),
                playerDTO.get().team()
        );
        Team team = new Team(teamDTO.get().name(),
                teamDTO.get().baseLocation(),
                teamDTO.get().coachName(),
                player);
        team.setCaptain(null);
        player.setTeam(null);
        player.setFielded(false);
        playerDAO.update(PlayerDTO.toDTO(player));
        teamDAO.update(TeamDTO.toDTO(team));
    }
}
