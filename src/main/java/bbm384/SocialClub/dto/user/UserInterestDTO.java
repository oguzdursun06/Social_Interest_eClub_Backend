package bbm384.SocialClub.dto.user;

import bbm384.SocialClub.entity.Subclub;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInterestDTO {

    Subclub subclub;

    int interestRate;
}
