package accident.repository;

import java.util.List;

/**
 * Интерфейс реализующий способность
 *
 * @author Денис Висков
 * @version 1.0
 * @since 20.10.2020
 */
public interface Store<V> {
    V add(V some);
    List<V> findAll();
    void update(V some);
}
