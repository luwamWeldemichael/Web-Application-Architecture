package assignments.assignment3.repository;

import assignments.assignment3.domain.Logger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoggerRepo extends CrudRepository<Logger, Long> {
}
