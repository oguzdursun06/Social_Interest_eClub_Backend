package bbm384.SocialClub.dto.report;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportDTO {

    @NotBlank(message = "field is required")
    private String reason;

    private String type;

}