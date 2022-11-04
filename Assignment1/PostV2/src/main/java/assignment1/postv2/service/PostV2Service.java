package assignment1.postv2.service;

import assignment1.postv2.domain.PostV2;
import assignment1.postv2.domain.response.PostDto;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface PostV2Service {
    List<PostDto> getPosts();
    PostDto getPost(String author );
    String savePost( PostV2 postV2);
    String updatePost(PostV2 postV2 , long id);
    String deletePost( long id);
}
