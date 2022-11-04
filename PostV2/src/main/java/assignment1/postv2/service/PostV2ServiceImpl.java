package assignment1.postv2.service;

import assignment1.postv2.domain.PostV2;
import assignment1.postv2.domain.response.PostDto;
import assignment1.postv2.repository.PostV2Repository;
//import lombok.var;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostV2ServiceImpl implements PostV2Service{
    @Autowired
    PostV2Repository postV2Repository;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public List<PostDto> getPosts() {
//        return postV2Repository.getPosts();
        var posts = postV2Repository.getPosts();
        return posts
                .stream()
                .map(p-> modelMapper.map(p, PostDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public PostDto getPost(String author) {
//        var post = postV2Repository.getPost(id);
//        PostDto postDto = new PostDto(post.getId(), post.getTitle(), post.getContent(), post.getAuthor());
//        return postDto;
        return modelMapper.map(postV2Repository.getPost(author), PostDto.class);
    }
    @Override
    public String savePost(PostV2 postV2) {
        return postV2Repository.savePost(postV2);
    }
    @Override
    public String updatePost(PostV2 postV2, long id) {
        return postV2Repository.updatePost(postV2, id);
    }
    @Override
    public String deletePost(long id){
        return postV2Repository.deletePost(id);
    }
}
