package services;

import model.Player;
import model.PlayerDTO;
import model.TeamDTO;
import persistence.DAO;
import persistence.TeamDAO;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;


public class UpdateTeamService {
    private final TeamDAO<TeamDTO, String, PlayerDTO> dao;
    private final DAO<PlayerDTO, Integer> daoPlayer;

    public UpdateTeamService(TeamDAO<TeamDTO, String, PlayerDTO> dao, DAO<PlayerDTO, Integer> daoPlayer) {
        this.dao = dao;
        this.daoPlayer = daoPlayer;
    }

    public TeamDTO getTeam(String key){
        Objects.requireNonNull(key, "id/nome do time não pode ser nulo");
        if(key.isBlank())
            throw new IllegalArgumentException("id/nome não pode ser vazia");
        var team = dao.findByKey(key);
        if(team.isEmpty())
            throw new NoSuchElementException("não foi possivel encontrar time com nome: "+key);
        return team.get();
    }

    public void updateTeamBaseLocation(String teamKey, String baseLocation){
        var team = getTeam(teamKey);
        Objects.requireNonNull(baseLocation, "localização não pode ser nula");
        if(baseLocation.isBlank())
            throw new IllegalArgumentException("localização não pode ser vazia");
        dao.update(new TeamDTO(team.name(),
                baseLocation,
                team.coachName(),
                team.captain()));
    }

    public void updateTeamCoachName(String teamKey, String coachName){
        var team = getTeam(teamKey);
        Objects.requireNonNull(coachName, "nome do tecnico não pode ser nulo");
        if(coachName.isBlank())
            throw new IllegalArgumentException("nome do tecnico não pode estar vazio");
        dao.update(new TeamDTO(team.name(),
                team.baseLocation(),
                coachName,
                team.captain()));
    }

    public void updateCaptain(String teamKey, int idCaptain){
        var team = getTeam(teamKey);
        Optional<PlayerDTO> player = dao.findAllChildren(teamKey)
                .stream()
                .filter((p) -> p.id() == idCaptain)
                .findAny();
        if(player.isEmpty())
            throw new NoSuchElementException("novo capitão não é jogador do time "+teamKey);
        var playerDTO = player.get();
        if(team.captain() != null && team.captain().id() == idCaptain) return;
        var teamDTOUpdated = new TeamDTO(
                team.name(),
                team.baseLocation(),
                team.coachName(),
                playerDTO
        );
        if(team.captain() == null){
            dao.update(teamDTOUpdated);
            return;
        }
        if(playerDTO.isFielded()) {
            dao.update(teamDTOUpdated);
            return;
        }
        substitution(team.captain(), playerDTO);
        dao.update(teamDTOUpdated);
    }

    public void substitution(PlayerDTO playerInField, PlayerDTO playerOutField){
        daoPlayer.update(new PlayerDTO(
                playerInField.id(),
                playerInField.position(),
                playerInField.name(),
                playerInField.number(),
                !playerInField.isFielded(),
                playerInField.team()));
        daoPlayer.update(new PlayerDTO(
                playerOutField.id(),
                playerOutField.position(),
                playerOutField.name(),
                playerOutField.number(),
                !playerOutField.isFielded(),
                playerOutField.team()));
    }

}
