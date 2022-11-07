package assignments.assignment3.service;

import assignments.assignment3.domain.Post;
import assignments.assignment3.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();
     User findById( long id);
     void save( User user);
    List<Post> getUserPosts(long id);
    void deleteById(long id);

    List<User> getUserWhosePostAboveN(int n);

    List<User> getUserWhoPostedTitle(String title);

    User getUserWhoPostedACommentWithID(long id, long postId, long commentId);

}
