package bbm384.SocialClub.controller;

import bbm384.SocialClub.dto.request.RequestClubDTO;
import bbm384.SocialClub.dto.request.RequestSubclubDTO;
import bbm384.SocialClub.entity.*;
import bbm384.SocialClub.mapper.RequestClubMapper;
import bbm384.SocialClub.mapper.RequestSubAdminMapper;
import bbm384.SocialClub.mapper.RequestSubclubMapper;
import bbm384.SocialClub.repository.*;
import bbm384.SocialClub.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Random;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/request")
public class RequestController {


    private final ClubRequestRepository clubRequestRepository;
    private final SubclubRequestRepository subclubRequestRepository;
    private final SubclubAdminRequestRepository subclubAdminRequestRepository;
    private final RequestService requestService;

    @PostMapping("/{userId}/createClub")
    public ClubRequest addRequestForClub(@PathVariable Long userId, @RequestBody @Valid RequestClubDTO requestClubDTO){
        return requestService.addRequestForClub(userId,requestClubDTO);

    }

    @PostMapping("/{userId}/createSubclub/{clubId}")
    public SubclubRequest addRequestForClub(@PathVariable Long userId, @PathVariable Long clubId, @RequestBody @Valid RequestSubclubDTO requestSubclubDTO){
        return requestService.addRequestForClub(userId,clubId,requestSubclubDTO);
    }

    @GetMapping("/{userId}/admin/{subclubId}")
    public SubclubAdminRequest addRequestForSubadmin(@PathVariable Long userId, @PathVariable Long subclubId){
        return requestService.addRequestForSubadmin(userId, subclubId);

    }
    @GetMapping("/club/getAll")
    public List<ClubRequest> getAllClubRequest(){
        return clubRequestRepository.findAll();
    }

    @GetMapping("/subclub/getAll")
    public List<SubclubRequest> getAllSubclubRequest(){
        return subclubRequestRepository.findAll();
    }

    @GetMapping("/admin/getAll")
    public List<SubclubAdminRequest> getAllSubclubAdmin(){
        return subclubAdminRequestRepository.findAll();
    }

    @GetMapping("/admin/assign/{subclubName}")
    @Transactional
    public Subclub assignSubAdmin(@PathVariable String subclubName){
        return requestService.assignSubAdmin(subclubName);
    }

    @GetMapping("/club/delete/{clubName}")
    @Transactional
    public void deleteClubRequest(@PathVariable String clubName){
        requestService.deleteClubRequest(clubName);
    }

    @GetMapping("/subclub/delete/{subclubName}")
    @Transactional
    public void deleteSubclubRequest(@PathVariable String subclubName){
        requestService.deleteSubclubRequest(subclubName);
    }


}
