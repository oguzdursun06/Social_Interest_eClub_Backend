package bbm384.SocialClub.controller;

import bbm384.SocialClub.dto.admin.StatisticDTO;
import bbm384.SocialClub.dto.club.CreateClubDTO;
import bbm384.SocialClub.entity.Club;
import bbm384.SocialClub.mapper.ClubMapper;
import bbm384.SocialClub.repository.*;
import bbm384.SocialClub.service.ClubService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/club")
public class ClubController {

    private final ClubRepository clubRepository;
    private final ClubMapper clubMapper;
    private final ClubService clubService;

    @PostMapping("/create")
    @PreAuthorize("permitAll()")
    public void createClub(@RequestBody @Valid CreateClubDTO createClubDTO){
        Club newClub = clubMapper.mapToEntity(createClubDTO);
        clubService.createNewClub(newClub);
    }

    @PostMapping("/update/{clubId}")
    @PreAuthorize("permitAll()")
    public Club updateClub(@PathVariable Long clubId, @RequestBody Club updatedClub){
        return clubService.updateClub(clubId,updatedClub);
    }

    @DeleteMapping("/delete/{clubId}")
    @PreAuthorize("permitAll()")
    public void deleteClub(@PathVariable Long clubId){
        clubRepository.deleteById(clubId);
    }

    @GetMapping("/getAll")
    @PreAuthorize("permitAll()")
    public List<Club> listAllClubs(){
        return clubRepository.findAll();
    }

    @GetMapping("/getOne/{clubId}")
    @PreAuthorize("permitAll()")
    public Club getOne(@PathVariable Long clubId){
        return clubRepository.findById(clubId).get();
    }

    @GetMapping("/getStat")
    @PreAuthorize("permitAll()")
    public StatisticDTO getStatistics(){
        return clubService.getStatistics();
    }


}
