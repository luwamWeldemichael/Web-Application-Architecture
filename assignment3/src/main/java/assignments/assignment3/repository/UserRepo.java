package assignments.assignment3.repository;

import assignments.assignment3.domain.Post;
import assignments.assignment3.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    @Query("Select user.posts from User user where user.id = :id")
    List<Post> getUserPosts(long id);


    @Query("select user from User user where user.posts.size > :n")
    List<User> getUserWhosePostAboveN(int n);

    @Query(value="SELECT * FROM USERS WHERE ID = SELECT USER_ID FROM POST WHERE title = :title", nativeQuery = true)
    List<User> getUserWhoPostedTitle(String title);

    @Query(value= "SELECT * FROM USERS WHERE ID = SELECT USER_ID FROM POST WHERE ID = SELECT POST_ID FROM COMMENT WHERE ID = 1" , nativeQuery = true)
    User getUserWhoPostedACommentWithID(long UserId, long postId, long commentId);
}
