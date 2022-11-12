package edu.miu.assignment6.repo;

import edu.miu.assignment6.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
    List<User> findAll();

    @Query(value = "SELECT u from User u where size(u.posts) > :n")
    List<User> findUsersWithMoreThanOnePost(int n);

    @Query(value = "SELECT distinct u from User u join Post p on p.user = u where p.title = :title")
    List<User> findUsersWithPostTitle(String title);

    @Query(value = "SELECT distinct u from User u join Post p on p.user = u where p.title = :postTitle and size(u.posts) > :numberOfPosts")
    List<User> findUsersByNumberOfPostsAndTitle(Integer numberOfPosts, String postTitle);

    User findByEmail(String username);
}
