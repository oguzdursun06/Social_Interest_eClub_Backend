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
@SequenceGenerator(name="COMMENT_SEQ", sequenceName="comment_sequence",allocationSize = 1)
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMMENT_SEQ")
    private Long id;

    private String username;

    private LocalDateTime commentDate;

    private String comment;

    private Double rate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subclub_id", referencedColumnName = "id")
    @JsonIgnore
    private Subclub subclub;

}
