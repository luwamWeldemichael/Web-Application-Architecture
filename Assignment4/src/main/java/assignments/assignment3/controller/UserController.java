package assignments.assignment3.controller;

import assignments.assignment3.aspect.ExecutionTime;
import assignments.assignment3.domain.Post;
import assignments.assignment3.domain.User;
import assignments.assignment3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @ExecutionTime
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

    @GetMapping("/posts/{num}")
    public List<User> getUserWhosePostAboveN(@PathVariable("num") int num){
        return userService.getUserWhosePostAboveN(num);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id){
        userService.deleteById(id);
    }

    @GetMapping("/posts/with/{title}")
    public List<User> getUserWhoPostedTitle(@PathVariable String title){
        return userService.getUserWhoPostedTitle(title);
    }

    @GetMapping("/{id}/posts/{postId}/comments/{commentId}")
    public User getUserWhoPostedACommentWithID(@PathVariable long id, @PathVariable long postId, @PathVariable long commentId){
        return userService.getUserWhoPostedACommentWithID(id, postId, commentId);
    }


    @ExecutionTime
    @GetMapping("/exception/{id}")
    public void findByIdWithException(@PathVariable long id) throws Throwable{
        //dummy logic just to demonstrate that the Aspect can log several exception types
        if(id==0){
            throw new NullPointerException();
        }
        else {
            throw new Throwable();
        }
    }
}
