package kg.rakhim.classes.thechheim.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDtoForPassword {
    private String oldPassword;
    private String newPassword;
}
