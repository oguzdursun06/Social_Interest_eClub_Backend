package bbm384.SocialClub.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name="SUBCLUB_REQ_SEQ", sequenceName="subclub_req_sequence",allocationSize = 1)
public class SubclubRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SUBCLUB_REQ_SEQ")
    private Long id;

    private String name;

    private int clubRequest = 0;

    @ManyToOne
    private Club club;

    @ManyToMany
    private List<Users> users = new ArrayList<>();

    public void addUsers(Users user){
        users.add(user);
    }


}
