package assignment1.post.repository;

import assignment1.post.domain.Post;

import java.util.List;

public interface PostRepository {
    List<Post> getPosts();
    Post getPost(long id);
    String savePost(Post p);
    String updatePost(Post p, long postId);
    String deletePost(long id);
}
