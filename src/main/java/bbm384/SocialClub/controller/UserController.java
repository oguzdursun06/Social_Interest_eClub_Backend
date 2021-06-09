package bbm384.SocialClub.controller;

import bbm384.SocialClub.dto.user.SubclubsRelatedUserDTO;
import bbm384.SocialClub.dto.user.UserInterestDTO;
import bbm384.SocialClub.entity.Subclub;
import bbm384.SocialClub.entity.UserSubclubAttempt;
import bbm384.SocialClub.entity.Users;
import bbm384.SocialClub.mapper.SubclubsRelatedUserMapper;
import bbm384.SocialClub.repository.SubclubRepository;
import bbm384.SocialClub.repository.UserSubclubAttemptRepository;
import bbm384.SocialClub.repository.UsersRepository;
import bbm384.SocialClub.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {


    private final UsersRepository usersRepository;
    private final UserService userService;

    @PutMapping("/{subclubId}/enroll/{username}")
    public UserSubclubAttempt enrollUserToSubclub(@PathVariable Long subclubId, @PathVariable String username){
        return userService.enrollUserToSubclub(subclubId,username);
    }


    @GetMapping("/available/{username}")
    public List<SubclubsRelatedUserDTO> getAllCanJoin(@PathVariable String username){
        return userService.getAllCanJoin(username);
    }


    @GetMapping("/joined/{username}")
    public List<SubclubsRelatedUserDTO> getAbilityToJoin(@PathVariable String username){
        return userService.getAbilityToJoin(username);
    }

    @GetMapping("/nonjoined/{username}")
    public List<SubclubsRelatedUserDTO> getInabilityToJoin(@PathVariable String username){
        return userService.getInabilityToJoin(username);
    }


    @GetMapping("/answerTo/{username}")
    public List<SubclubsRelatedUserDTO> haveToAnswerQuestion(@PathVariable String username){
        return userService.haveToAnswerQuestion(username);
    }

    @GetMapping("/getInfo/{username}")
    public Users getUserInformation(@PathVariable String username){
        return usersRepository.findByUsername(username);
    }


    @GetMapping("/interest/{username}")
    public List<UserInterestDTO> getInterests(@PathVariable String username){
        return userService.getInterests(username);
    }

    @GetMapping("/questions/{username}")
    public List<Subclub> getQuestions(@PathVariable String username){
        return userService.getQuestions(username);
    }

    @GetMapping("/questions/{username}/{subclubId}")
    public List<Subclub> getQuestionsFromSubclub(@PathVariable String username, @PathVariable Long subclubId){
        return userService.getQuestionsFromSubclub(username,subclubId);
    }

    @GetMapping("/getAll")
    public List<Users> getAllUsers(){
        return usersRepository.getAllUsers();
    }



}
