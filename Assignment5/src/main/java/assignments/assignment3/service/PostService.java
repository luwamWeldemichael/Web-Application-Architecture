package assignments.assignment3.service;


import assignments.assignment3.domain.Post;

import java.util.List;

public interface PostService {
    List<Post> getPosts();
    Post getPost(long id);
    String savePost(Post p);
    String updatePost(Post p, long postId);
    String deletePost(long id);
    List<Post> getPosts(String title);
}
