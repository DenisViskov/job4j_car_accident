package accident.repository;

import accident.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Интерфейс реализующий способность
 *
 * @author Денис Висков
 * @version 1.0
 * @since 25.10.2020
 */
public interface UserRepository extends CrudRepository<User, Integer> {
}
