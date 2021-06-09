package bbm384.SocialClub.controller;

import bbm384.SocialClub.dto.subclub.CreateSubclubDTO;
import bbm384.SocialClub.entity.Club;
import bbm384.SocialClub.entity.Question;
import bbm384.SocialClub.entity.Subclub;
import bbm384.SocialClub.entity.Users;
import bbm384.SocialClub.mapper.SubclubMapper;
import bbm384.SocialClub.repository.*;
import bbm384.SocialClub.service.SubclubService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/subclub")
@RequiredArgsConstructor
public class SubclubController {

    private final SubclubRepository subclubRepository;
    private SubclubService subclubService;

    @PostMapping("create/{clubId}")
    @Transactional
    public Subclub createClub(@PathVariable Long clubId, @RequestBody @Valid CreateSubclubDTO createSubclubDTO){
        return subclubService.createClub(clubId,createSubclubDTO);
    }

    @PostMapping("/update/{subclubId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Club updateClub(@PathVariable Long subclubId, @RequestBody Subclub updatedSubclub){
        Subclub subclub = subclubRepository.findById(subclubId).get();
        return null;
    }

    @DeleteMapping("/delete/{subclubId}")
    @PreAuthorize("permitAll()")
    public void deleteSubclub(@PathVariable Long subclubId){
        subclubRepository.deleteById(subclubId);
    }

    @GetMapping("/getAll")
    @PreAuthorize("permitAll()")
    public List<Subclub> listAllClubs(){
        return subclubRepository.findAll();
    }

    @GetMapping("/getOne/{subclubId}")
    @PreAuthorize("permitAll()")
    public Subclub getOneSubclub(@PathVariable Long subclubId){
        return subclubRepository.findById(subclubId).get();
    }


    @GetMapping("/getUsers/{subclubId}")
    @PreAuthorize("permitAll()")
    public List<Users> getUsersFromSubclub(@PathVariable Long subclubId){
        return subclubService.getUsersFromSubclub(subclubId);
    }





}
