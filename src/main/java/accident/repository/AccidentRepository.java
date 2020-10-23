package accident.repository;

import accident.model.Accident;
import accident.model.AccidentEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Интерфейс реализующий способность
 *
 * @author Денис Висков
 * @version 1.0
 * @since 23.10.2020
 */
public interface AccidentRepository extends CrudRepository<AccidentEntity, Integer> {
}
