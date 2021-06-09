package bbm384.SocialClub.service;

import bbm384.SocialClub.dto.subclub.CreateSubclubDTO;
import bbm384.SocialClub.entity.Club;
import bbm384.SocialClub.entity.Subclub;
import bbm384.SocialClub.entity.Users;
import bbm384.SocialClub.mapper.SubclubMapper;
import bbm384.SocialClub.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SubclubService {

    private final SubclubRepository subclubRepository;
    private final ClubRepository clubRepository;
    private final UsersRepository usersRepository;
    private final SubclubMapper subclubMapper;
    private final QuestionRepository questionRepository;
    private final UserSubclubAttemptRepository userSubclubAttemptRepository;

    public Subclub createClub(Long clubId, CreateSubclubDTO createSubclubDTO){
        Club club = clubRepository.findById(clubId).get();
        Subclub subclub = subclubMapper.mapToEntity(createSubclubDTO);
        subclub.setClub(club);
        questionRepository.saveAll(createSubclubDTO.getQuestions().stream().map(index -> {index.setSubclub(subclub);
            return index;
        }).collect(Collectors.toList()));
        return subclubRepository.save(subclub);
    }


    public List<Users> getUsersFromSubclub(Long subclubId){
        List<Long> allUserFromSubclub = userSubclubAttemptRepository.getAllUserFromSubclub(subclubId);
        List<Users> collectedUsers = allUserFromSubclub.stream().map(id -> usersRepository.findById(id).get()).collect(Collectors.toList());
        return collectedUsers;
    }
}
