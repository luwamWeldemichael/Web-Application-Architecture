package assignments.assignment3.controller;

import assignments.assignment3.domain.Comment;
import assignments.assignment3.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@CrossOrigin(allowedHeaders = "Access-control-Allow-origin")
@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping
    public List<Comment> getAllComments(){
        return commentService.getAllComments();
    }


    @PostMapping("/{post_id}")
    public void saveComment(@RequestBody Comment comment ,@PathVariable long post_id){
        commentService.saveComment(comment);
    }
}
