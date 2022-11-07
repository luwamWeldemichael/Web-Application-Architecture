package assignments.assignment3.service;

import assignments.assignment3.domain.Post;
import assignments.assignment3.domain.User;
import assignments.assignment3.repository.PostRepo;
import assignments.assignment3.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable long id) {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }

    @PostMapping
    public void save(@RequestBody User user) {
        userRepo.save(user);
    }

    @Override
    public List<Post> getUserPosts(long id) {
        return userRepo.getUserPosts(id);
    }

    @Override
    public void deleteById(long id) {
        userRepo.deleteById(id);
    }

    @Override
    public List<User> getUserWhosePostAboveN(int n) {
        return userRepo.getUserWhosePostAboveN(n);
    }

    @Override
    public List<User> getUserWhoPostedTitle(String title) {
        return userRepo.getUserWhoPostedTitle(title);
    }

    @Override
    public User getUserWhoPostedACommentWithID(long id, long postId, long commentId) {
        return userRepo.getUserWhoPostedACommentWithID(id, postId, commentId);
    }
}
