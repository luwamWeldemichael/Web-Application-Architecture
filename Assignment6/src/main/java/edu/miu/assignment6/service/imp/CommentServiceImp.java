package edu.miu.assignment6.service.imp;

import edu.miu.assignment6.entity.Comment;
import edu.miu.assignment6.entity.dto.CommentDto;
import edu.miu.assignment6.repo.CommentRepo;
import edu.miu.assignment6.repo.PostRepo;
import edu.miu.assignment6.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImp implements CommentService {
    @Autowired
    CommentRepo commentRepo;

    @Autowired
    PostRepo postRepo;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public void save(long postId, CommentDto commentDto) {
        Comment c = modelMapper.map(commentDto, Comment.class);
        c.setPost(postRepo.findById(postId).get());
        commentRepo.save(c);
    }

    @Override
    public List<CommentDto> findAllByPostIDAndUserId(long postId, long userId) {
        var post = postRepo.findById(userId).get();
        return post != null ? post.getComments().stream().map(e -> modelMapper.map(e, CommentDto.class)).collect(Collectors.toList()) : new ArrayList<CommentDto>();

    }

    @Override
    public CommentDto findByIdAndPostIDAndUserId(long commentId, long postId, long userId) {
        var post = postRepo.findByUserIdAndId(userId, postId);
        if( post == null )
            return  null;
        else{
            var comment = commentRepo.findById(commentId).orElse(null);
            if(comment != null)
                return modelMapper.map(comment, CommentDto.class);
            else
                return null;
        }
    }
}
