package assignment1.post.repository;

import assignment1.post.domain.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepoImpl implements PostRepository{

    private static List<Post> posts ;
    static {
        posts = new ArrayList<>();
        posts.add(new Post(1, "first post" , "hello" , "Luwam"));
        posts.add(new Post(2, "second post" , "hello Luwam" , "John"));
        posts.add(new Post(3, "third post" , "hello John" , "Joe"));
    }

    @Override
    public List<Post> getPosts() {
        return posts;
    }

    @Override
    public Post getPost(long id) {
        for (Post p: posts){
            if(p.getId()==id){
                return p;
            }
        }
        return null;
    }

    @Override
    public String savePost(Post p) {
        posts.add(p);
        return p + " successfully saved";
    }

    @Override
    public String updatePost(Post p, long postId) {
        Post postToBeUpdated = getPost(postId);
        if(postToBeUpdated!=null){
            postToBeUpdated.setAuthor(p.getAuthor());
            postToBeUpdated.setContent(p.getContent());
            postToBeUpdated.setTitle(p.getTitle());
            return postToBeUpdated + " successfully updated";
        }
        return null;
    }

    @Override
    public String deletePost(long id) {
        Post postToBeDeleted = getPost(id);
        posts.remove(postToBeDeleted);
        return postToBeDeleted + " successfully deleted";
    }
}
