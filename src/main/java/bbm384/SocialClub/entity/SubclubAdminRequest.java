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
@SequenceGenerator(name="SUBCLUB_ADMIN_REQ_SEQ", sequenceName="subclub_admin_req_sequence",allocationSize = 1)
public class SubclubAdminRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SUBCLUB_ADMIN_REQ_SEQ")
    private Long id;

    private String name;

    @ManyToMany
    private List<Users> users = new ArrayList<>();

    public void addUsers(Users user){
        users.add(user);
    }


}
