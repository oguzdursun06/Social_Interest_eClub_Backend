package bbm384.SocialClub.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name="CLUB_REQ_SEQ", sequenceName="club_req_sequence",allocationSize = 1)
public class ClubRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLUB_REQ_SEQ")
    private Long id;

    private String name;

    private int clubRequest = 0;

    @ManyToMany
    private List<Users> users = new ArrayList<>();

    public void addUsers(Users user){
        users.add(user);
    }


}
