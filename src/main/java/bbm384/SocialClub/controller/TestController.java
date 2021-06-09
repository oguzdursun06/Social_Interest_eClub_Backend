package bbm384.SocialClub.controller;
import bbm384.SocialClub.dto.subclub.CreateSubclubDTO;
import bbm384.SocialClub.entity.*;
import bbm384.SocialClub.mapper.DenemeMapper;
import bbm384.SocialClub.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final UsersRepository usersRepository;
    private final AuthorityRepository authorityRepository;
    private final ClubRepository clubRepository;
    private final SubclubRepository subclubRepository;
    private final UserSubclubAttemptRepository userSubclubAttemptRepository;
    private final DenemeMapper denemeMapper;
    private final CommentRepository commentRepository;

    @GetMapping("/change/{userId}")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    @Transactional
    public Users change(@PathVariable Long userId){
        Optional<Users> users = usersRepository.findById(userId);
        authorityRepository.deleteByUsername(users.get().getUsername());
        List<Authority> authorities = new ArrayList<>();
        authorities.add(new Authority(null, users.get().getUsername(),"USER"));
        users.get().setAuthorities(authorities);
        return usersRepository.save(users.get());
    }

    @GetMapping("/user")
    public Users user(){
        return usersRepository.findByUsername("user");
    }




    @PostMapping("/subclub")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Subclub createSubclub(@RequestBody Subclub subclub){
        return subclubRepository.save(subclub);
    }

    @GetMapping("/{subclubId}/club/{clubId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Subclub assignClubToSubClub(@PathVariable Long subclubId, @PathVariable Long clubId){
        Subclub subclub = subclubRepository.findById(subclubId).get();
        Club club = clubRepository.findById(clubId).get();

        subclub.setClub(club);
        return subclubRepository.save(subclub);
    }

    @PostMapping("/addTogether")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Subclub addTogether(@PathVariable Long subclubId, @PathVariable Long clubId){
        Subclub subclub = subclubRepository.findById(subclubId).get();
        Club club = clubRepository.findById(clubId).get();

        subclub.setClub(club);
        return subclubRepository.save(subclub);
    }


/*


    @GetMapping("denem")
    public List<Subclub> getDenem(){
        List<Subclub> all = subclubRepository.findAll();

        List<UserSubclubAttempt> allByUserIdAndPointGreaterThan = userSubclubAttemptRepository.findAllByUserIdAndPointGreaterThan(2L, 22);
        List<Subclub> collect = allByUserIdAndPointGreaterThan.stream().map(x -> subclubRepository.findById(x.getSubclubId()).get()).collect(Collectors.toList());
        return collect;
    } */




}
