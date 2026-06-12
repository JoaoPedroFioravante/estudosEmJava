package persistence;

import model.PlayerDTO;
import model.TeamDTO;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SqliteTeam implements TeamDAO<TeamDTO, String, PlayerDTO> {
    @Override
    public void add(TeamDTO entity) {
        String sql = "INSERT INTO TEAM (name, base_location, coach_name) VALUES (?,?,?)";
        try (var preparedStatement = ConnectionFactoryMethod.getPreparedStatement(sql)){
            preparedStatement.setString(1, entity.name());
            preparedStatement.setString(2, entity.baseLocation());
            preparedStatement.setString(3, entity.coachName());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            System.err.println(e.getMessage() + "\n falha ao adicionar time");
        }
    }

    @Override
    public void remove(String key) {
        String sql = "DELETE FROM TEAM WHERE NAME = ?";
        try(var preparedStatement = ConnectionFactoryMethod.getPreparedStatement(sql)){
            preparedStatement.setString(1, key);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage() + "\n falha ao remover time de id: "+ key);
        }
    }

    @Override
    public void update(TeamDTO entity) {
        String sql = "UPDATE TEAM SET base_location = ?, coach_name = ?, captain = ? WHERE name = ?";
        try(var preparedStatement = ConnectionFactoryMethod.getPreparedStatement(sql)){
            preparedStatement.setString(1, entity.baseLocation());
            preparedStatement.setString(2, entity.coachName());
            if(entity.captain() == null){
                preparedStatement.setNull(3, Types.INTEGER);
            }
            else {
                preparedStatement.setInt(3, entity.captain().id());
            }
            preparedStatement.setString(4, entity.name());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            System.err.println(e.getMessage() + "\n falha ao atualizar time de id: "+entity.name());
        }
    }

    @Override
    public Optional<TeamDTO> findByKey(String key) {
        String sql = "SELECT * FROM TEAM WHERE NAME = ?";
        try (var preparedStatement = ConnectionFactoryMethod.getPreparedStatement(sql)){
            preparedStatement.setString(1, key);
            var resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                int idCaptain = resultSet.getInt("captain");
                return Optional.of(
                        new TeamDTO(
                                resultSet.getString("name"),
                                resultSet.getString("base_location"),
                                resultSet.getString("coach_name"),
                                findAllChildren(key).stream()
                                        .filter((p)-> p.id() == idCaptain).findAny().orElse(null)
                        )
                );
            }
        }
        catch (SQLException e){
            System.err.println(e.getMessage() + "falha pesquisar team pelo id");
        }
        return Optional.empty();
    }

    @Override
    public boolean entityExists(String key) {
        String sql = "SELECT * FROM TEAM WHERE NAME = ?";
        try (var preparedStatement = ConnectionFactoryMethod.getPreparedStatement(sql)){
            preparedStatement.setString(1, key);
            return preparedStatement.executeQuery().next();
        }
        catch (SQLException e){
            System.err.println(e.getMessage() + "\n falha ao verificar se a entidade existe");
        }
        return false;
    }

    @Override
    public List<PlayerDTO> findAllChildren(String key){
        String sql = "SELECT * FROM PLAYER WHERE TEAM_NAME = ?";
        List<PlayerDTO> players =new ArrayList<>();
        try (var preparedStatement =  ConnectionFactoryMethod.getPreparedStatement(sql)){
            preparedStatement.setString(1, key);
            var resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                players.add(new PlayerDTO(
                        resultSet.getInt("id"),
                        resultSet.getString("position"),
                        resultSet.getString("name"),
                        resultSet.getInt("number"),
                        resultSet.getInt("is_field") != 0,
                        resultSet.getString("team_name")
                ));
            }
        }
        catch (SQLException e){
            System.err.println(e.getMessage() + "\n falha ao buscar players");
        }
        return players;
    }
}
