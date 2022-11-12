package assignments.assignment3.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Table(name = "users")
public class User {
    @Id
    long id;
    String name;
    private String email;
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "User_ID")
    List<Post> posts;

    @Transient
    public static String principal = "Luwam";

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "UserRole")
    private List<Role> roles;
}
