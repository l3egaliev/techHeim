package kg.rakhim.classes.thechheim.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

}
