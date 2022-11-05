package assignments.assignment3.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Table(name = "Users")
public class User {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "User_ID")
    List<Post> posts;
}
