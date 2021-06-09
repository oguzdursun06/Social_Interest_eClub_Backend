package bbm384.SocialClub.service;

import bbm384.SocialClub.dto.questionaire.AnswerDTO;
import bbm384.SocialClub.entity.Question;
import bbm384.SocialClub.entity.UserSubclubAttempt;
import bbm384.SocialClub.repository.SubclubRepository;
import bbm384.SocialClub.repository.UserSubclubAttemptRepository;
import bbm384.SocialClub.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@Service
public class QuestionService {

    private final UserSubclubAttemptRepository userSubclubAttemptRepository;
    private final SubclubRepository subclubRepository;
    private final UsersRepository usersRepository;


    public UserSubclubAttempt answerQuestion(Long subclubId, String username, AnswerDTO answerDTO){
        Long id = usersRepository.findByUsername(username).getId();
        List<Question> questions = subclubRepository.findById(subclubId).get().getQuestions();
        int count = 0;
        for (int i = 0; i < questions.size(); i++) {
            if(questions.get(i).getAnswer().equals(answerDTO.answers.get(i))){
                count++;
            }
        }
        return userSubclubAttemptRepository.save(new UserSubclubAttempt(null,id,subclubId,false,count*100/questions.size()));
    }
}
