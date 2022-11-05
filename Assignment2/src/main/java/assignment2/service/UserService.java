package assignment2.lab2.service;

import assignment2.lab2.domain.Post;
import assignment2.lab2.domain.User;
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
    List<User> getUserWithMoreThan1Post();
}
