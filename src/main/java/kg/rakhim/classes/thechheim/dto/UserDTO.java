package kg.rakhim.classes.thechheim.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String username;
    @NotNull(message = "Password couldn't be empty!")
    @Size(min = 8, max = 16, message = "Min 8, max 16 symbols!")
    private String password;
}
