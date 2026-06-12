package main;

import initializer.DatabaseInitializer;
import model.Player;
import model.PlayerDTO;
import model.Team;
import model.TeamDTO;
import persistence.DAO;
import persistence.SqlitePlayer;
import persistence.SqliteTeam;
import persistence.TeamDAO;
import services.*;

import java.util.Arrays;

public class Main {
    public static void main() {
        DatabaseInitializer.dropTables();
        DatabaseInitializer.createTables();
        Player[] players = {
                new Player(1, "teste1", "meia", 3, false),
                new Player(2, "test2", "zag", 56, false),
                new Player(3, "test3", "ata", 99, false),
                new Player(3, "pooTeste", "ata", 999, true),
                new Player(10, "test90", "gk", 1, false)
        };
        Team[] teams = {
                new Team("Sao Paulo", "são paulo", "dorival"),
                new Team("palmeiras", "são paulo", "abel ferreira")
        };
        DAO<PlayerDTO, Integer> playerDAO = new SqlitePlayer();
        TeamDAO<TeamDTO, String, PlayerDTO> teamDAO = new SqliteTeam();
        AddPlayerTeamService addPlayerTeamService = new AddPlayerTeamService(playerDAO, teamDAO);
        CreatePlayerService createPlayerService = new CreatePlayerService(playerDAO);
        CreateTeamService createTeamService = new CreateTeamService(teamDAO);
        GetAllPlayerOfTeamService getAllPlayerOfTeamService = new GetAllPlayerOfTeamService(teamDAO);
        GetPlayerService getPlayerService = new GetPlayerService(playerDAO);
        GetTeamService getTeamService = new GetTeamService(teamDAO);
        RemovePlayerService removePlayerService = new RemovePlayerService(playerDAO);
        RemovePlayerTeamService removePlayerTeamService = new RemovePlayerTeamService(teamDAO, playerDAO);
        RemoveTeamService removeTeamService = new RemoveTeamService(teamDAO);
        UpdatePlayerService updatePlayerService = new UpdatePlayerService(playerDAO);
        UpdateTeamService updateTeamService = new UpdateTeamService(teamDAO, playerDAO);
        for (Player value : players) {
            try {
                createPlayerService.createPlayer(value);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        try {
            Arrays.stream(teams).forEach(createTeamService::createTeam);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        try {
            var player = getPlayerService.getPlayer(1);
            if (player.isPresent())
                System.out.println(player.get().toString());
            else
                System.out.println("player não existe na base de dados");
            player = getPlayerService.getPlayer(100);
            if (player.isPresent())
                System.out.println(player.get().toString());
            else
                System.out.println("player não existe na base de dados");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        try {
            var team = getTeamService.getTeam("Sao Paulo");
            if (team.isPresent())
                System.out.println(team.get().toString());
            else
                System.out.println("time não existe na base de dados");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        try {
            updatePlayerService.updatePlayerNumber(1, 999);
            updatePlayerService.updatePlayerPosition(1, "ataque");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        try {
            var player = getPlayerService.getPlayer(1);
            if (player.isPresent())
                System.out.println(player.get().toString());
            else
                System.out.println("player não existe na base de dados");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        try {
            updateTeamService.updateTeamCoachName("Sao Paulo", "dorival junior");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        try {
            var team = getTeamService.getTeam("Sao Paulo");
            if (team.isPresent())
                System.out.println(team.get().toString());
            else
                System.out.println("team não cadastrado na base de dados");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        try {
            System.out.println(getAllPlayerOfTeamService.getAllPlayer("Sao Paulo"));
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        try {
            addPlayerTeamService.addPlayerToTeam("Sao Paulo", 1);
            addPlayerTeamService.addPlayerToTeam("Sao Paulo", 3);
            addPlayerTeamService.addPlayerToTeam("Sao Paulo", 10);
            addPlayerTeamService.addPlayerToTeam("Sao Paulo", 2);
            addPlayerTeamService.addPlayerToTeam("Sao Paulo", 2);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        try {
            System.out.println(getAllPlayerOfTeamService.getAllPlayer("Sao Paulo"));
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        try {
            updateTeamService.updateCaptain("Sao Paulo", 10);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
       /* teste de remoção do capitão sem ser pelo service do removePlayerTeamService
        try {
            removePlayerService.removePlayer(10);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }*/
        System.out.println();
        try {
            removePlayerTeamService.removePlayerOfTeam("Sao Paulo", 3);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        try {
            System.out.println(getAllPlayerOfTeamService.getAllPlayer("Sao Paulo"));
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        try {
            var team = getTeamService.getTeam("Sao Paulo");
            if (team.isPresent())
                System.out.println(team.get().toString());
            else
                System.out.println("team não cadastrado na base de dados");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        try {
            removeTeamService.removeTeam("Sao Paulo");
            removeTeamService.removeTeam("Sao Pao");
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
        try {
            var team = getTeamService.getTeam("Sao Paulo");
            if (team.isPresent())
                System.out.println(team.get().toString());
            else
                System.out.println("team não cadastrado na base de dados");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
    }
}
