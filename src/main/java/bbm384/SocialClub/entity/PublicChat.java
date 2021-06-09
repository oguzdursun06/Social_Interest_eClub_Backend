package bbm384.SocialClub.entity;

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
@SequenceGenerator(name="PUBLIC_SEQ", sequenceName="public_sequence",allocationSize = 1)
public class PublicChat {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PUBLIC_SEQ")
    private Long id;

    private String username;

    private String message;

    private LocalDateTime messageDate;

    @ManyToOne()
    @JoinColumn(name = "subclub_id", referencedColumnName = "id")
    @JsonIgnore
    private Subclub subclub;
}
