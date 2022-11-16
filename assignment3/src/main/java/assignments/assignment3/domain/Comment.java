package assignments.assignment3.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class Comment {
    @Id
//    @GeneratedValue(strategy= GenerationType.AUTO)
    long id;
    String name;

    @ManyToOne
    Post post;
}
