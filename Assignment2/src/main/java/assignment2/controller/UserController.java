package assignment2.lab2.controller;

import assignment2.lab2.domain.Post;
import assignment2.lab2.domain.User;
import assignment2.lab2.repository.UserRepo;
import assignment2.lab2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable long id){
        return userService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody User user){
        userService.save(user);
    }

    @GetMapping("/{id}/posts")
    public List<Post> getUserPosts(@PathVariable long id){
        return userService.getUserPosts(id);
    }

    @GetMapping("/filter/post")
    public List<User> getUserWithMoreThan1Post(){
        return userService.getUserWithMoreThan1Post();
    }
}
