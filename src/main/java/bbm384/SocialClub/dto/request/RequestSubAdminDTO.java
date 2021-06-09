package bbm384.SocialClub.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestSubAdminDTO {

    @NotBlank(message = "field is required")
    private String name;

}
