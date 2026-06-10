package initializer;

import persistence.ConnectionFactoryMethod;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseInitializer {
    private DatabaseInitializer(){};

    public static void createTables(){
        createTablesPlayer();
        createTablesTeam();
    }

    public static void createTablesPlayer(){
        String sql = """
                create table if not exists player(
                    ID INTEGER,
                  NAME TEXT,
                  NUMBER INTEGER not null,
                  POSITION TEXT,
                  IS_FIELD INTEGER default 0,
                  TEAM_NAME TEXT default null,
                  constraint player_pk primary key(ID),
                    constraint player_team_name_fk foreign key (TEAM_NAME) references TEAM(NAME) on delete set null
                );
                """;
        try(var preparedStatementTablePlayer = ConnectionFactoryMethod.getPreparedStatement(sql)){
            preparedStatementTablePlayer.executeUpdate();
        }
        catch (SQLException e){
            System.err.println(e.getMessage() + "\n falha ao criar tabela player");
        }
    }

    public static void createTablesTeam(){
        String sql = """
                create table if not exists team(
                    NAME TEXT,
                    BASE_LOCATION TEXT,
                    COACH_NAME TEXT,
                    CAPTAIN INTEGER default null,
                    CONSTRAINT team_pk primary key (NAME),
                    CONSTRAINT team_captain_fk foreign key (CAPTAIN) REFERENCES player(ID) on delete set null
                );
                """;
        try(var preparedStatementTableTeam = ConnectionFactoryMethod.getPreparedStatement(sql)){
            preparedStatementTableTeam.executeUpdate();
        }
        catch (SQLException e){
            System.err.println(e.getMessage() + "\n falha ao criar tabela team");
        }
    }

    public static void dropTables(){
        dropTablePlayer();
        dropTableTeam();
    }

    public static void dropTablePlayer(){
        String sqlDropPlayer = "drop table player";
        try(var preparedStatementPlayer = ConnectionFactoryMethod.getPreparedStatement(sqlDropPlayer)) {
            preparedStatementPlayer.executeUpdate();
        }
        catch (SQLException e){
            System.err.println(e.getMessage() + "\n falha ao excluir tabela player");
        }
    }

    public static void dropTableTeam(){
        String sqlDropTeam = "drop table team";
        try(var preparedStatementTeam = ConnectionFactoryMethod.getPreparedStatement(sqlDropTeam)) {
            preparedStatementTeam.executeUpdate();
        }
        catch (SQLException e){
            System.err.println(e.getMessage() + "\n falha ao excluir tabela team");
        }
    }
}
