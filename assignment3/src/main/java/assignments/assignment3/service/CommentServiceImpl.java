package assignments.assignment3.service;

import assignments.assignment3.domain.Comment;
import assignments.assignment3.repository.CommentRepo;
import assignments.assignment3.repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    CommentRepo commentRepo;

    @Autowired
    PostRepo postRepo;

    @Override
    public void saveComment(Comment comment) {
        commentRepo.save(comment);
    }

    @Override
    public List<Comment> getAllComments() {
        return commentRepo.findAll();
    }

}
