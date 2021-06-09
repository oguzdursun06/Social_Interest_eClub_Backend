package bbm384.SocialClub.entity;

import bbm384.SocialClub.dto.report.ReportDTO;
import bbm384.SocialClub.dto.request.RequestClubDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name="PRIVATE_SEQ", sequenceName="private_sequence",allocationSize = 1)
public class PrivateChat {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRIVATE_SEQ")
    private Long id;

    private Users sendUser;

    private Users receiveUser;

    private String message;

    private LocalDateTime messageDate;

}
