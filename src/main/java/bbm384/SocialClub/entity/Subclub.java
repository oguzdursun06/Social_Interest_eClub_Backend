package bbm384.SocialClub.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name="SUBCLUB_SEQ", sequenceName="subclub_sequence",allocationSize = 1)
public class Subclub {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SUBCLUB_SEQ")
    private Long id;

    private String name;

    private String description;

    private String imageURL;

    private int clubMember = 0;

    @ManyToOne()
    @JoinColumn(name = "club_id", referencedColumnName = "id")
    @JsonIgnore
    private Club club;

    @OneToMany(mappedBy = "subclub", cascade = CascadeType.ALL)
    private List<Question> questions;

    @OneToMany(mappedBy = "subclub", cascade = CascadeType.ALL)
    private List<Comment> comments;

    @OneToMany(mappedBy = "subclub", cascade = CascadeType.ALL)
    private List<PublicChat> publicChats;

    @OneToMany(mappedBy = "subclub", cascade = CascadeType.ALL)
    private List<Event> events;

    private Users subclubAdmin;


}
