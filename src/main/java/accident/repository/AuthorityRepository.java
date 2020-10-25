package accident.repository;

import accident.model.Authority;
import org.springframework.data.repository.CrudRepository;

/**
 * Интерфейс реализующий способность
 *
 * @author Денис Висков
 * @version 1.0
 * @since 25.10.2020
 */
public interface AuthorityRepository extends CrudRepository<Authority, Integer> {
    Authority findByAuthority(String authority);
}
