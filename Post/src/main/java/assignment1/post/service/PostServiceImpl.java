package assignment1.post.service;

import assignment1.post.domain.Post;
import assignment1.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    PostRepository postRepository;

    @Override
    public List<Post> getPosts() {
        return postRepository.getPosts();
    }

    @Override
    public Post getPost(long id) {
        return postRepository.getPost(id);
    }

    @Override
    public String savePost(Post p) {
        return postRepository.savePost(p);
    }

    @Override
    public String updatePost(Post p, long postId) {
        return postRepository.updatePost(p,postId);
    }

    @Override
    public String deletePost(long id) {
        return postRepository.deletePost(id);
    }
}
