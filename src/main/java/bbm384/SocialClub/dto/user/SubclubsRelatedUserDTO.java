package bbm384.SocialClub.dto.user;

import bbm384.SocialClub.entity.Club;
import bbm384.SocialClub.entity.Question;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubclubsRelatedUserDTO {


    private Long id;

    private String name;

    private String description;

    private String imageURL;

    private int clubMember = 0;

    private int point = -1;

    private List<Question> questions;

}
