package services;

import model.PlayerDTO;
import persistence.DAO;

import java.util.NoSuchElementException;

public class RemovePlayerService {
    private final DAO<PlayerDTO, Integer> dao;

    public RemovePlayerService(DAO<PlayerDTO, Integer> dao) {
        this.dao = dao;
    }

    public void removePlayer(int key){
        if(!dao.entityExists(key)) throw new NoSuchElementException("elemento não encontrado: "+key);
        dao.remove(key);
    }

}
