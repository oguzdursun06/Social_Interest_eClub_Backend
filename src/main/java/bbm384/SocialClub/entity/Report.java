package bbm384.SocialClub.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name="REPORT_SEQ", sequenceName="req_sequence",allocationSize = 1)
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REPORT_SEQ")
    private Long id;

    @OneToOne
    private Users user;

    @OneToOne
    private Users reportedBy;

    @OneToOne
    private Subclub subclub;

    private String reason;

    private String type;


}
