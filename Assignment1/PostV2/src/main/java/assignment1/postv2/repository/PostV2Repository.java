package assignment1.postv2.repository;

import assignment1.postv2.domain.PostV2;
import assignment1.postv2.domain.response.PostDto;

import java.util.List;

public interface PostV2Repository {
    List<PostV2> getPosts();
    PostV2 getPost(String author );
    String savePost( PostV2 postV2);
    String updatePost(PostV2 postV2 , long id);
    String deletePost( long id);
}
