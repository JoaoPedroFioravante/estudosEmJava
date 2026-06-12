package services;

import exceptions.PlayerAlreadyHasTeam;
import model.Player;
import model.PlayerDTO;
import model.TeamDTO;
import persistence.DAO;
import persistence.TeamDAO;

import java.util.NoSuchElementException;
import java.util.Objects;

public class AddPlayerTeamService {
    private final DAO<PlayerDTO, Integer> daoPlayer;
    private final TeamDAO<TeamDTO, String, PlayerDTO> daoTeam;

    public AddPlayerTeamService(DAO<PlayerDTO, Integer> daoPlayer, TeamDAO<TeamDTO, String, PlayerDTO> daoTeam) {
        this.daoPlayer = daoPlayer;
        this.daoTeam = daoTeam;
    }

    public void addPlayerToTeam(String teamKey, int playerKey){
        Objects.requireNonNull(teamKey, "id/nome do time não pode ser nulo");
        if(teamKey.isBlank())
            throw new IllegalArgumentException("id/nome do time não pode estar vazio");
        var team = daoTeam.findByKey(teamKey);
        if(team.isEmpty())
            throw new NoSuchElementException("time não existe na base de dados");
        var player = daoPlayer.findByKey(playerKey);
        if(player.isEmpty())
            throw new NoSuchElementException("player não existe na base de dados");
        if(player.get().team() != null)
            throw new PlayerAlreadyHasTeam("player de id: "+ playerKey +" não pode ser cadastrado no time de id: " +teamKey+ " pois ja possui time");
        Player playerAdded = new Player(player.get().id(),
                player.get().name(),
                player.get().position(),
                player.get().number(),
                player.get().isFielded(),
                team.get().name()
                );
        long quantityPlayerInField = daoTeam.findAllChildren(team.get().name())
                .stream()
                .map(PlayerDTO::isFielded)
                .filter((f)-> f)
                .count();
        playerAdded.setFielded(quantityPlayerInField < 12);
        daoPlayer.update(PlayerDTO.toDTO(playerAdded));
    }
}
