package assignment2.lab2.service;

import assignment2.lab2.domain.Post;
import assignment2.lab2.repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    PostRepo postRepo;
    @Override
    public List<Post> getPosts() {
        return postRepo.findAll();
    }

    @Override
    public Post getPost(long id) {
       Optional<Post> post =  postRepo.findById(id);
        if(post.isPresent()){
            return post.get();
        }
        return null;
    }

    @Override
    public String savePost(Post p) {
        postRepo.save(p);
        return "successfully saved";
    }

    @Override
    public String updatePost(Post p, long postId) {
        Post postToBeUpdated = postRepo.findById(postId).get();
        postToBeUpdated.setAuthor(p.getAuthor());
        postToBeUpdated.setContent(p.getContent());
        postToBeUpdated.setTitle(p.getTitle());
        return "successfully updated";
    }

    @Override
    public String deletePost(long id) {
        postRepo.deleteById(id);
        return "successfully deleted";
    }


}
