package bbm384.SocialClub.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name="CLUB_SEQ", sequenceName="club_sequence",allocationSize = 1)
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLUB_SEQ")
    private Long id;

    private String name;

    private String description;

    private String imageURL;

    private int clubMember = 0;

    @OneToMany(mappedBy = "club", cascade = CascadeType.ALL)
    private List<Subclub> subclubs;

}
