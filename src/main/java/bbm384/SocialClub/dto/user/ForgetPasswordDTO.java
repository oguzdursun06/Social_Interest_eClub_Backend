package bbm384.SocialClub.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ForgetPasswordDTO {

    @Email(message = "Email format is not valid.")
    @NotBlank(message = "Email field is required")
    private String email;
}
