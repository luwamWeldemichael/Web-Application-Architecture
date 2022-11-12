package edu.miu.assignment6.service.imp;

import edu.miu.assignment6.entity.Comment;
import edu.miu.assignment6.entity.Post;
import edu.miu.assignment6.entity.dto.CommentDto;
import edu.miu.assignment6.entity.dto.PostDto;
import edu.miu.assignment6.repo.CommentRepo;
import edu.miu.assignment6.repo.PostRepo;
import edu.miu.assignment6.service.PostService;
import edu.miu.assignment6.util.ListMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImp implements PostService {

    @Autowired
    PostRepo postRepo;

    @Autowired
    CommentRepo commentRepo;
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper<Post, PostDto> listMapper;

    @Override
    public List<PostDto> findAll() {
        var posts = postRepo.findAll();
        return (List<PostDto>) listMapper.mapList(posts, new PostDto());
    }

    @Override
    public PostDto findById(long id) {
        var post = postRepo.findById(id).orElse(null);
        return post == null ? null :  modelMapper.map(post, PostDto.class);
    }

    @Override
    public List<PostDto> findByTitle(String title) {
        var posts = postRepo.findByTitle(title);
        return (List<PostDto>) listMapper.mapList(posts, new PostDto());
    }

    @Override
    public void deleteById(long id) {
        postRepo.deleteById(id);
    }

    @Override
    public void save(PostDto p) {
        postRepo.save(modelMapper.map(p, Post.class));
    }

    @Override
    public void update(long postId, PostDto p) {
        p.setId(postId);
        postRepo.save(modelMapper.map(p, Post.class));
    }

    @Override
    public List<PostDto> findByAuthor(String author) {
        var posts = postRepo.findByAuthor(author);
        return (List<PostDto>) listMapper.mapList(posts, new PostDto());
    }

    @Override
    public List<PostDto> findByUserId(long userId) {
        var posts = postRepo.findByUserId(userId);
        return (List<PostDto>) listMapper.mapList(posts, new PostDto());
    }

    @Override
    public PostDto findByUserIdAndId(long userId, long postId) {
        var post = postRepo.findByUserIdAndId(userId, postId);
        return post == null ? null :  modelMapper.map(post, PostDto.class);
    }

    @Override
    public void addComment(long userId, long postId, CommentDto commentDto) {
        var post = postRepo.findByUserIdAndId(userId, postId);

        if( post != null )
        {
            Comment c = modelMapper.map(commentDto, Comment.class);
            c.setPost(post);
            commentRepo.save(c);
        }
    }

    @Override
    public List<PostDto> findByAuthorAndTitle(String author, String title) {
        if(author != null && title != null)
            return (List<PostDto>) listMapper.mapList(postRepo.findByAuthorAndTitle(author, title), new PostDto());
        else if(author != null)
            return findByAuthor(author);
        else
            return findByTitle(title);
    }
}
