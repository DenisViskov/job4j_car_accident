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
public interface RepositoryService<V, T, K> {
    Optional<V> findByIdAccident(int id);

    List<V> getAllAccidents();

    void saveAccident(V some);

    void updateAccident(V some);

    Optional<T> findByIdType(int id);

    List<T> getAllTypes();

    void saveType(T some);

    void updateType(T some);

    Optional<K> findByIdRule(int id);

    List<K> getAllRules();

    void saveRule(K some);

    void updateRule(K some);

}
