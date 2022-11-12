package assignments.assignment3.controller;

import assignments.assignment3.Util.JwtUtil;
import assignments.assignment3.domain.Post;
import assignments.assignment3.domain.dto.response.LoginResponse;
import assignments.assignment3.service.AuthService;
import assignments.assignment3.service.Implementation.MyUserDetails;
import assignments.assignment3.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping
    public List<Post> getPosts(){
        return postService.getPosts();
    }

    @GetMapping("/{id}")
    public Post findById(@PathVariable long id){
        return postService.getPost(id);
    }

    @PostMapping
    public String savePost(@RequestBody Post post){

        return postService.savePost(post);
    }

    @PutMapping("/{id}")
    public String updatePost(@RequestBody Post post , @PathVariable long id){
        return postService.updatePost(post, id);
    }

    @DeleteMapping("/delete/{id}")
    public String deletePost(@PathVariable long id){
        return postService.deletePost(id);
    }

    @GetMapping("/with/{title}")
    public List<Post> getPosts(@PathVariable String title){
        return postService.getPosts(title);
    }
}
