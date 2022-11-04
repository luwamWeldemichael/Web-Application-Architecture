package assignment1.postv2.controller;

import assignment1.postv2.domain.PostV2;
import assignment1.postv2.domain.response.PostDto;
import assignment1.postv2.service.PostV2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v2/posts")
public class PostV2Controller {
    @Autowired
    PostV2Service postV2Service;

    @GetMapping
    public List<PostDto> getPosts(){
        return postV2Service.getPosts();
    }

    @GetMapping("/{author}")
    public PostDto getPost(@PathVariable String author){
        return postV2Service.getPost(author);
    }

    @PostMapping
    public String savePost(@RequestBody PostV2 post){
        return postV2Service.savePost(post);
    }

    @PutMapping("/{id}")
    public String updatePost(@RequestBody PostV2 post , @PathVariable long id){
        return postV2Service.updatePost(post, id);
    }

    @PutMapping("/delete/{id}")
    public String deletePost(@PathVariable long id){
        return postV2Service.deletePost(id);
    }
}
