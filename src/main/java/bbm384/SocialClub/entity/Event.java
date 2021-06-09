package bbm384.SocialClub.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@SequenceGenerator(name="EVENT_SEQ", sequenceName="event_sequence",allocationSize = 1)
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EVENT_SEQ")
    private Long id;

    private String name;

    private String date;

    private String description;

    private String eventPlatform;

    private String eventLink;

    @ManyToOne()
    @JoinColumn(name = "subclub_id", referencedColumnName = "id")
    @JsonIgnore
    private Subclub subclub;


}