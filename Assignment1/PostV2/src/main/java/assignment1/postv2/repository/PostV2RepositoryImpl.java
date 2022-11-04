package assignment1.postv2.repository;

import assignment1.postv2.domain.PostV2;
import assignment1.postv2.domain.response.PostDto;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostV2RepositoryImpl implements PostV2Repository{
    private static List<PostV2> posts ;
    static {
        posts = new ArrayList<>();
        posts.add(new PostV2(1, "first post" , "hello" , "Luwam"));
        posts.add(new PostV2(2, "second post" , "hello Luwam" , "John"));
        posts.add(new PostV2(3, "third post" , "hello John" , "Joe"));
    }

    @Override
    public List<PostV2> getPosts() {
        return posts;
    }

    @Override
    public PostV2 getPost(String author) {
        for (PostV2 p: posts){
            if(p.getAuthor().equals(author)){
                return p;
            }
        }
        return null;
    }

    @Override
    public String savePost(PostV2 p) {
        posts.add(p);
        return p + " successfully saved";
    }

    @Override
    public String updatePost(PostV2 p, long postId) {
        for (PostV2 postV2: posts){
            if(p.getId()==(postId)) {
                postV2.setAuthor(p.getAuthor());
                postV2.setContent(p.getContent());
                postV2.setTitle(p.getTitle());
                return postV2 + " successfully updated";
            }
        }
        return null;
    }

    @Override
    public String deletePost(long id) {
        for (PostV2 p: posts){
            if(p.getId()==(id)) {
                posts.remove(p);
                return p + " successfully deleted";
            }
        }
        return "Post with id: " + id + " is not deleted.";
    }
}
