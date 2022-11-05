package assignments.assignment3.service;

import assignments.assignment3.domain.Comment;

import java.util.List;

public interface CommentService {
    void saveComment(Comment comment);

    List<Comment> getAllComments();
}
