package persistence;

import model.PlayerDTO;

import java.sql.SQLException;
import java.util.Optional;

public class SqlitePlayer implements DAO<PlayerDTO, Integer> {

    @Override
    public void add(PlayerDTO entity) {
        String sql = "INSERT INTO PLAYER (id, name, number, position) VALUES(?,?,?,?)";
        try(var preparedStatement = ConnectionFactoryMethod.getPreparedStatement(sql)){
            preparedStatement.setInt(1, entity.id());
            preparedStatement.setString(2, entity.name());
            preparedStatement.setInt(3, entity.number());
            preparedStatement.setString(4, entity.position());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.err.println(e.getMessage() + "\n falha ao adicionar player");
        }
    }

    @Override
    public void remove(Integer key) {
        String sql = "DELETE FROM PLAYER WHERE ID = ?";
        try(var preparedStatement = ConnectionFactoryMethod.getPreparedStatement(sql)){
            preparedStatement.setInt(1,key);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.err.println(e.getMessage() + "\n falha ao excluir player de id: "+key);
        }
    }

    @Override
    public void update(PlayerDTO entity) {
        String sql = "UPDATE PLAYER SET  NUMBER = ?, POSITION = ?, IS_FIELD = ?, TEAM_NAME = ? WHERE ID = ?";
        try(var preparedStatement = ConnectionFactoryMethod.getPreparedStatement(sql)){
            preparedStatement.setInt(1, entity.number());
            preparedStatement.setString(2, entity.position());
            preparedStatement.setInt(3, entity.isFielded()?1:0);
            preparedStatement.setString(4, entity.team());
            preparedStatement.setInt(5, entity.id());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            System.err.println(e.getMessage() + "\n falha ao atualizar o player de id: "+entity.id());
        }
    }
    @Override
    public Optional<PlayerDTO> findByKey(Integer key) {
        String sql = "SELECT * FROM PLAYER WHERE ID = ?";
        try (var preparedStatement = ConnectionFactoryMethod.getPreparedStatement(sql)){
            preparedStatement.setInt(1, key);
            var resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                return Optional.of(
                        new PlayerDTO(resultSet.getInt("id"),
                                resultSet.getString("position"),
                                resultSet.getString("name"),
                                resultSet.getInt("number"),
                                resultSet.getInt("is_field") == 1,
                                resultSet.getString("team_name"))
                );
            }
        }
        catch (SQLException e){
            System.err.println(e.getMessage() + "\n falha ao pesquisar player");
        }
        return Optional.empty();
    }

    @Override
    public boolean entityExists(Integer key) {
        String sql = "SELECT * FROM PLAYER WHERE ID = ?";
        try (var preparedStatement = ConnectionFactoryMethod.getPreparedStatement(sql)){
            preparedStatement.setInt(1, key);
            return preparedStatement.executeQuery().next();
        }
        catch (SQLException e){
            System.err.println(e.getMessage() + "\n falha ao verificar a existencia de player");
        }
        return false;
    }
}
