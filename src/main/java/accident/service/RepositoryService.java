package accident.service;

import java.util.List;
import java.util.Optional;

/**
 * Интерфейс реализующий способность
 *
 * @author Денис Висков
 * @version 1.0
 * @since 20.10.2020
 */
public interface RepositoryService<V> {
    Optional<V> findById(int id);
    List<V> getAll();
    void save(V some);
    void update(V some);
}
