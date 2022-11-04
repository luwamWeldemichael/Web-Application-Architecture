package assignment1.post.service;

import assignment1.post.domain.Post;

import java.util.List;

public interface PostService {
    List<Post> getPosts();
    Post getPost(long id);
    String savePost(Post p);
    String updatePost(Post p, long postId);
    String deletePost(long id);
}
