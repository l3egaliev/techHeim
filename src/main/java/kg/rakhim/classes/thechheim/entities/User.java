package kg.rakhim.classes.thechheim.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JoinColumnOrFormula;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username")
    @NotNull(message = "Username couldn't be empty!")
    private String username;

    @Column(name = "password")
    @NotNull(message = "Password couldn't be empty!")
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "email")
    @Email
    @NotNull(message = "Поле email не может быть пустым!")
    private String email;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "users_likes",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "blog_id"))
    public List<BlogEntity> likedBlogs = new ArrayList<>();

}
