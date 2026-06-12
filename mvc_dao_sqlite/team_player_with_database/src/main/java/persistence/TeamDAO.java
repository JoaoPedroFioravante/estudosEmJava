package persistence;

import java.util.List;
import java.util.Optional;

public interface TeamDAO<T, K, E> extends DAO<T, K> {
    List<E> findAllChildren(K key);
}
