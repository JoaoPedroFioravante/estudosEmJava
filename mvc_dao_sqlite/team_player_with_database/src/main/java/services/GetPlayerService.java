package services;

import model.Player;
import model.PlayerDTO;
import model.Team;
import model.TeamDTO;
import persistence.DAO;
import persistence.TeamDAO;

import java.util.Optional;

public class GetPlayerService {
    private final DAO<PlayerDTO, Integer> dao;

    public GetPlayerService(DAO<PlayerDTO, Integer> dao) {
        this.dao = dao;
    }

    public Optional<Player> getPlayer(int key){
        var playerDTO =  dao.findByKey(key);
        return playerDTO.map(dto -> new Player(dto.id(),
                dto.name(),
                dto.position(),
                dto.number(),
                dto.isFielded(),
                dto.team()
        ));
    }
}
