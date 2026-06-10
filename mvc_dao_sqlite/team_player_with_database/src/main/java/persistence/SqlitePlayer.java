package persistence;

import model.PlayerDTO;

import java.util.Optional;

public class SqlitePlayer implements DAO<PlayerDTO, Integer> {

    @Override
    public void add(PlayerDTO entity) {

    }

    @Override
    public void remove(Integer key) {

    }

    @Override
    public void update(PlayerDTO entity) {

    }

    @Override
    public Optional<PlayerDTO> findByKey(Integer key) {
        return null;
    }

    @Override
    public boolean entityExists(Integer key) {
        return false;
    }
}
