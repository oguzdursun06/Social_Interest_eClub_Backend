package bbm384.SocialClub.dto;

import bbm384.SocialClub.entity.Club;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class DenemeDto {

    private Long id;

    private String name;

    private Club club;


}

