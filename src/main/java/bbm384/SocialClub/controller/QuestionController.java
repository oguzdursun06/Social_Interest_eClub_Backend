package bbm384.SocialClub.controller;

import bbm384.SocialClub.dto.questionaire.AnswerDTO;
import bbm384.SocialClub.dto.subclub.CreateSubclubDTO;
import bbm384.SocialClub.entity.Question;
import bbm384.SocialClub.entity.UserSubclubAttempt;
import bbm384.SocialClub.repository.SubclubRepository;
import bbm384.SocialClub.repository.UserSubclubAttemptRepository;
import bbm384.SocialClub.repository.UsersRepository;
import bbm384.SocialClub.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Properties;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/question")
public class QuestionController {

    private final QuestionService questionService;

    @PutMapping("/{subclubId}/users/{username}")
    public UserSubclubAttempt answerQuestion(@PathVariable Long subclubId, @PathVariable String username, @RequestBody @Valid AnswerDTO answerDTO){
       return questionService.answerQuestion(subclubId, username, answerDTO);
    }

}
