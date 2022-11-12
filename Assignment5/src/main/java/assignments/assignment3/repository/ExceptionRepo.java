package assignments.assignment3.repository;

import assignments.assignment3.domain.MyException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExceptionRepo extends CrudRepository<MyException, Long> {
}
