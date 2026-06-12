package services;

import model.Player;
import model.PlayerDTO;
import model.TeamDTO;
import persistence.TeamDAO;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.StringJoiner;

public class GetAllPlayerOfTeamService {
    private final TeamDAO<TeamDTO, String, PlayerDTO> dao;

    public GetAllPlayerOfTeamService(TeamDAO<TeamDTO, String, PlayerDTO> dao) {
        this.dao = dao;
    }

    public String getAllPlayer(String teamKey){
        Objects.requireNonNull(teamKey, "id/nome do time não pode ser nulo");
        if(teamKey.isBlank())
            throw new IllegalArgumentException("id/nome do time não pode estar vazio");
        if(!dao.entityExists(teamKey))
            throw new NoSuchElementException("time não existe na base de dados");
        StringJoiner joiner = new StringJoiner("\n");
        joiner.setEmptyValue("team não tem nenhum player cadastrado");
        var players = dao.findAllChildren(teamKey);
        players.stream()
                .map((p) -> new Player(
                        p.id(),
                        p.name(),
                        p.position(),
                        p.number(),
                        p.isFielded(),
                        p.team()
                ))
                .map(Player::toString)
                .forEach(joiner::add);
        return joiner.toString();
    }
}
