package bbm384.SocialClub.controller;


import bbm384.SocialClub.dto.subclub.CreateSubclubDTO;
import bbm384.SocialClub.entity.Club;
import bbm384.SocialClub.entity.Event;
import bbm384.SocialClub.entity.Subclub;
import bbm384.SocialClub.repository.EventRepository;
import bbm384.SocialClub.repository.SubclubRepository;
import bbm384.SocialClub.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/event")
public class EventController {

    private final EventRepository eventRepository;
    private final EventService eventService;

    @PostMapping("create/{subclubId}")
    @Transactional
    public Event createClub(@PathVariable Long subclubId, @RequestBody @Valid Event event){
        return eventService.createClub(subclubId,event);
    };

    @GetMapping("get/{subclubId}")
    @Transactional
    public List<Event> getAll(@PathVariable Long subclubId){
        return eventRepository.getAllEvents(subclubId);
    }
}
