package services;

import exceptions.EntityAlreadyExists;
import model.Player;
import model.PlayerDTO;
import persistence.DAO;

import java.util.Objects;

public class CreatePlayerService {
    private final DAO<PlayerDTO, Integer> dao;

    public CreatePlayerService(DAO<PlayerDTO, Integer> dao) {
        this.dao = dao;
    }

    public void createPlayer(Player player){
        Objects.requireNonNull(player, "player não pode ser nulo");
        Objects.requireNonNull(player.getName(), "nome do player não pode ser nulo");
        Objects.requireNonNull(player.getPosition(), "posição não pode ser nulo");
        if(player.getName().isBlank())
            throw new IllegalArgumentException("nome do player não pode estar vazio");
        if(player.getPosition().isBlank())
            throw new IllegalArgumentException("posição do player não pode estar vazio");
        if(dao.entityExists(player.getId()))
            throw new EntityAlreadyExists("player ja cadastrado na base de dados");
        dao.add(PlayerDTO.toDTO(player));
    }
}
