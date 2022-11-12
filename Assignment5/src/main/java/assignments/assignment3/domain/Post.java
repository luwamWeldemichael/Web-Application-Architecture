package assignments.assignment3.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Post {

    @Id
    long id;
    String title;
    String content;
    String author;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_Id")
    List<Comment> comments;
}