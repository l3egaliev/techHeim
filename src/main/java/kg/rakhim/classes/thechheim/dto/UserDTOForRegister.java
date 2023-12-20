package kg.rakhim.classes.thechheim.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTOForRegister {
    private String username;
    private String email;
    @NotNull(message = "Password couldn't be empty!")
    @Size(min = 8, max = 16, message = "Min 8, max 16 symbols!")
    private String password;
}
