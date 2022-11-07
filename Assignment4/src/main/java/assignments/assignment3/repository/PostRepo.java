package assignments.assignment3.repository;

import assignments.assignment3.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post, Long> {

    @Query("Select p from Post p where p.title = :title")
    List<Post> getPosts(String title);
}
