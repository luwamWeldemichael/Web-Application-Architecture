package assignment2.lab2.service;

import assignment2.lab2.domain.Post;
import assignment2.lab2.domain.User;
import assignment2.lab2.repository.PostRepo;
import assignment2.lab2.repository.UserRepo;
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
    public List<User> getUserWithMoreThan1Post() {
        return userRepo.getUserWithMoreThan1Post();
    }

}
