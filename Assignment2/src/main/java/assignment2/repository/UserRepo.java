package assignment2.lab2.repository;

import assignment2.lab2.domain.Post;
import assignment2.lab2.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    @Query("Select user.posts from User user where user.id = :id")
    List<Post> getUserPosts(long id);

    @Query("Select u from User u where u.posts.size >=1")
    List<User> getUserWithMoreThan1Post();

}
