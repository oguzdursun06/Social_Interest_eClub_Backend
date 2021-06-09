package bbm384.SocialClub.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpDTO {


    @Size(min = 2, max = 18, message = "First name must be at least 4, at most 18 characters.")
    @NotBlank(message = "First name field is required")
    private String firstName;

    @Size(min = 2, max = 18, message = "Last name must be at least 4, at most 18 characters.")
    @NotBlank(message = "Last name field is required")
    private String lastName;

    @Size(min = 4, max=18, message = "Username must be at least 4, at most 18 characters.")
    @NotBlank(message = "Username field is required")
    private String username;

    private String birthDate;

    @Email(message = "Email format is not valid.")
    @NotBlank(message = "Email field is required")
    private String email;

    @Size(min = 6, message = "Password must be at least 6 characters.")
    @NotBlank(message = "Password field is required")
    private String password;



}
