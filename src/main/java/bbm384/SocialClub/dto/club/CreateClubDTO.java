package bbm384.SocialClub.dto.club;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateClubDTO {

    @NotBlank(message = "Club name field is required")
    @Size(min = 3, message = "Club name must be at least 3 characters.")
    private String name;

    private String description;

    private String imageURL;



}
