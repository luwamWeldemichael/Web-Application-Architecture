package assignment1.post.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Post {
    long id;
    String title;
    String content;
    String author;
}
