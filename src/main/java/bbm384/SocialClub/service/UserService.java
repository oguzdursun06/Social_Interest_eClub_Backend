package bbm384.SocialClub.service;

import bbm384.SocialClub.dto.user.SubclubsRelatedUserDTO;
import bbm384.SocialClub.dto.user.UserInterestDTO;
import bbm384.SocialClub.entity.Subclub;
import bbm384.SocialClub.entity.UserSubclubAttempt;
import bbm384.SocialClub.mapper.SubclubsRelatedUserMapper;
import bbm384.SocialClub.repository.SubclubRepository;
import bbm384.SocialClub.repository.UserSubclubAttemptRepository;
import bbm384.SocialClub.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserSubclubAttemptRepository userSubclubAttemptRepository;
    private final SubclubRepository subclubRepository;
    private final SubclubsRelatedUserMapper subclubsRelatedUserMapper;
    private final UsersRepository usersRepository;

    public UserSubclubAttempt enrollUserToSubclub(Long subclubId, String username){
        Subclub subclub = subclubRepository.findById(subclubId).get();
        Long id = usersRepository.findByUsername(username).getId();
        subclub.setClubMember(subclub.getClubMember()+1);
        subclub.getClub().setClubMember(subclub.getClub().getClubMember()+1);
        UserSubclubAttempt joinAttempt = userSubclubAttemptRepository.findBySubclubIdAndUserId(subclubId, id);
        joinAttempt.setJoined(true);
        return userSubclubAttemptRepository.save(joinAttempt);
    }

    public List<SubclubsRelatedUserDTO> getAllCanJoin(String username){
        Long id = usersRepository.findByUsername(username).getId();
        List<Long> userAnswered = userSubclubAttemptRepository.findAllCanJoin(id);
        List<Subclub> subclubList = subclubRepository.findAll();

        List<Subclub> filterByJoin = subclubList.stream().filter(subclub -> userAnswered.contains(subclub.getId())).collect(Collectors.toList());

        List<SubclubsRelatedUserDTO> filterByJoinDTO = subclubsRelatedUserMapper.mapToDto(filterByJoin);

        filterByJoinDTO.stream().map(subclub -> {subclub.setPoint(userSubclubAttemptRepository.findPoint(id,subclub.getId())); return subclub;}).collect(Collectors.toList());
        return filterByJoinDTO;
    }

    public List<SubclubsRelatedUserDTO> getAbilityToJoin(String username){
        Long id = usersRepository.findByUsername(username).getId();
        List<Long> userAnswered = userSubclubAttemptRepository.findAllJoinedSubclub(id);
        List<Subclub> subclubList = subclubRepository.findAll();

        List<Subclub> filterByJoin = subclubList.stream().filter(subclub -> userAnswered.contains(subclub.getId())).collect(Collectors.toList());

        List<SubclubsRelatedUserDTO> filterByJoinDTO = subclubsRelatedUserMapper.mapToDto(filterByJoin);

        filterByJoinDTO.stream().map(subclub -> {subclub.setPoint(userSubclubAttemptRepository.findPoint(id,subclub.getId())); return subclub;}).collect(Collectors.toList());
        return filterByJoinDTO;
    }

    public List<SubclubsRelatedUserDTO> getInabilityToJoin(String username){
        Long id = usersRepository.findByUsername(username).getId();
        List<Long> userAnswered = userSubclubAttemptRepository.findAllByLessThan(id,50);
        List<Subclub> subclubList = subclubRepository.findAll();

        List<Subclub> filterByNonjoin = subclubList.stream().filter(subclub -> userAnswered.contains(subclub.getId())).collect(Collectors.toList());

        List<SubclubsRelatedUserDTO> filterByNonjoinDTO = subclubsRelatedUserMapper.mapToDto(filterByNonjoin);

        filterByNonjoinDTO.stream().map(subclub -> {subclub.setPoint(userSubclubAttemptRepository.findPoint(id,subclub.getId())); return subclub;}).collect(Collectors.toList());
        return filterByNonjoinDTO;
    }

    public List<SubclubsRelatedUserDTO> haveToAnswerQuestion(String username){
        Long id = usersRepository.findByUsername(username).getId();
        List<Long> userAnswered = userSubclubAttemptRepository.findByUserId(id);
        List<Subclub> subclubList = subclubRepository.findAll();

        List<Subclub> filterByNonjoin = subclubList.stream().filter(subclub -> !userAnswered.contains(subclub.getId())).collect(Collectors.toList());

        List<SubclubsRelatedUserDTO> filterByNonjoinDTO = subclubsRelatedUserMapper.mapToDto(filterByNonjoin);

        filterByNonjoinDTO.stream().map(subclub -> {subclub.setPoint(-1); return subclub;}).collect(Collectors.toList());
        return filterByNonjoinDTO;
    }

    public List<UserInterestDTO> getInterests(String username){
        Long id = usersRepository.findByUsername(username).getId();
        List<Long> allInterests = userSubclubAttemptRepository.findAllInterests(id);

        List<Subclub> subclubList = subclubRepository.findAll();

        List<Subclub> filterByInterest = subclubList.stream().filter(subclub -> allInterests.contains(subclub.getId())).collect(Collectors.toList());

        List<UserInterestDTO> userInterestDTOS = new ArrayList<>();
        for(Subclub subclub : filterByInterest){
            userInterestDTOS.add(new UserInterestDTO(subclub,userSubclubAttemptRepository.findPoint(id, subclub.getId())));
        }

        return userInterestDTOS;
    }

    public List<Subclub> getQuestions(String username){
        Long id = usersRepository.findByUsername(username).getId();
        List<Long> allInterests = userSubclubAttemptRepository.findAllInterests(id);

        List<Subclub> subclubList = subclubRepository.findAll();

        List<Subclub> filterByInterest = subclubList.stream().filter(subclub -> !allInterests.contains(subclub.getId())).collect(Collectors.toList());

        return filterByInterest;
    }

    public List<Subclub> getQuestionsFromSubclub(@PathVariable String username, @PathVariable Long subclubId){
        List<Subclub> subclubs = new ArrayList<>();
        subclubs.add(subclubRepository.findById(subclubId).get());
        return subclubs;
    }

}
