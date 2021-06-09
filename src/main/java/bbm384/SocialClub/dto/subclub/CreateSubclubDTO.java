package bbm384.SocialClub.dto.subclub;

import bbm384.SocialClub.entity.Question;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateSubclubDTO {

    @NotBlank(message = "Subclub name field is required")
    private String name;

    private String description;

    private String imageURL;

    private List<Question> questions;
}
