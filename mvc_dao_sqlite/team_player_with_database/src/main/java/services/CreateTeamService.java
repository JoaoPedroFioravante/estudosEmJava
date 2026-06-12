package services;

import exceptions.EntityAlreadyExists;
import model.PlayerDTO;
import model.Team;
import model.TeamDTO;
import persistence.TeamDAO;

import java.util.Objects;

public class CreateTeamService {
    private final TeamDAO<TeamDTO, String, PlayerDTO> dao;

    public CreateTeamService(TeamDAO<TeamDTO, String, PlayerDTO> dao) {
        this.dao = dao;
    }

    public void createTeam(Team team){
        Objects.requireNonNull(team, "time não pode ser nulo para ser adicionado");
        Objects.requireNonNull(team.getName(), "nome do time não pode ser nulo");
        Objects.requireNonNull(team.getBaseLocation(), "localização do time não pode ser nulo");
        Objects.requireNonNull(team.getCoachName(), "nome do técnico não pode ser nulo");
        if(team.getName().isBlank()) throw new IllegalArgumentException("nome do time não pode estar vazio");
        if(team.getBaseLocation().isBlank()) throw new IllegalArgumentException("localização do time não pode estar vazia");
        if(team.getCoachName().isBlank()) throw new IllegalArgumentException("nome do tecnico do time não pode estar vazio");
        if(dao.entityExists(team.getName())) throw new EntityAlreadyExists("entidade já persistida");
        var teamDTO = TeamDTO.toDTO(team);
        dao.add(teamDTO);
    }
}
