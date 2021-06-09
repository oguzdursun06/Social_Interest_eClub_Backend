package bbm384.SocialClub.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name="ATTEMPT_SEQUENCE", sequenceName="attempt_sequence",allocationSize = 1)
public class UserSubclubAttempt {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ATTEMPT_SEQUENCE")
    private Long id;

    @JoinColumn(name = "user_id")
    private Long userId;

    @JoinColumn(name = "subclub_id")
    private Long subclubId;

    @JoinColumn(name = "is_joined")
    public boolean isJoined = false;

    public int point;


}
