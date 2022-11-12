package assignments.assignment3.service.Implementation;

import assignments.assignment3.domain.Post;
import assignments.assignment3.domain.User;
import assignments.assignment3.repository.PostRepo;
import assignments.assignment3.repository.UserRepo;
import assignments.assignment3.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepo postRepo;

    @Autowired
    UserRepo userRepo;
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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserEmail = authentication.getName();
        User user = userRepo.findByEmail(currentUserEmail);
        if(user!=null){
            user.getPosts().add(p);
            userRepo.save(user);
        }
        else{
            postRepo.save(p);
        }
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

    @Override
    public List<Post> getPosts(String title) {
        return postRepo.getPosts(title);
    }
}
