package services;

import model.PlayerDTO;
import persistence.DAO;

import java.util.NoSuchElementException;
import java.util.Objects;

public class UpdatePlayerService {
    private final DAO<PlayerDTO, Integer> dao;

    public UpdatePlayerService(DAO<PlayerDTO, Integer> dao) {
        this.dao = dao;
    }

    private PlayerDTO getPlayer(int key){
        var playerDTO = dao.findByKey(key);
        if(playerDTO.isEmpty()) throw new NoSuchElementException("player não existe para ser atualizado");
        return playerDTO.get();
    }

    public void updatePlayerNumber(int key, int newNumber){
        var player = getPlayer(key);
        if(player.number() == newNumber) return;
        dao.update(new PlayerDTO(
                player.id(),
                player.position(),
                player.name(),
                newNumber,
                player.isFielded(),
                player.team()));
    }

    public void updatePlayerPosition(int key, String newPosition){
        var player = getPlayer(key);
        Objects.requireNonNull(newPosition, "posição do player não pode ser nula");
        if(newPosition.isBlank())
            throw new IllegalArgumentException("posição do player não pode estar vazia");
        if(player.position().equals(newPosition))return;
        dao.update(new PlayerDTO(
                player.id(),
                newPosition,
                player.name(),
                player.number(),
                player.isFielded(),
                player.team()
        ));
    }
}
