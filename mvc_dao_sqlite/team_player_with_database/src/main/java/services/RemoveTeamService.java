package services;

import model.PlayerDTO;
import model.TeamDTO;
import persistence.TeamDAO;

import java.util.NoSuchElementException;

public class RemoveTeamService {
    private final TeamDAO<TeamDTO, String, PlayerDTO> dao;

    public RemoveTeamService(TeamDAO<TeamDTO, String, PlayerDTO> dao) {
        this.dao = dao;
    }

    public void removeTeam(String key){
        if(!dao.entityExists(key)) throw new NoSuchElementException("time não encontrado: "+key);
        dao.remove(key);
    }
}
