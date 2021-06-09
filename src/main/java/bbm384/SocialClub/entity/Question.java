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
@SequenceGenerator(name="QUESTION_SEQ", sequenceName="question_sequence",allocationSize = 1)
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QUESTION_SEQ")
    private Long id;

    private String question;

    private String option1;

    private String option2;

    private String option3;

    private String option4;

    private String answer;

    @ManyToOne()
    @JoinColumn(name = "subclub_id", referencedColumnName = "id")
    @JsonIgnore
    private Subclub subclub;
}
