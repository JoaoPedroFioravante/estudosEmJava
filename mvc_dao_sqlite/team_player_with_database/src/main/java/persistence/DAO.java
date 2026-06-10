package persistence;

import java.util.Optional;

public interface DAO<T, K> {
    void add(T entity);
    void remove(K key);
    void update(T entity);
    Optional<T> findByKey(K key);
    boolean entityExists(K key);
}
