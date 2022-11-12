package assignments.assignment3.repository;

import assignments.assignment3.domain.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepo extends CrudRepository<Comment, Long> {
    public List<Comment> findAll();
}
