package assignment2.lab2.service;


import assignment2.lab2.domain.Post;

import java.util.List;

public interface PostService {
    List<Post> getPosts();
    Post getPost(long id);
    String savePost(Post p);
    String updatePost(Post p, long postId);
    String deletePost(long id);

}
