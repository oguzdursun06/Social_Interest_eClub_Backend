package bbm384.SocialClub.service;

import bbm384.SocialClub.entity.Event;
import bbm384.SocialClub.entity.Subclub;
import bbm384.SocialClub.repository.EventRepository;
import bbm384.SocialClub.repository.SubclubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Service
@RequiredArgsConstructor
public class EventService {

    private final SubclubRepository subclubRepository;
    private final EventRepository eventRepository;

    public Event createClub(Long subclubId, Event event){
        Subclub subclub = subclubRepository.findById(subclubId).get();
        Event savedEvent = new Event(null, event.getName(), event.getDate(), event.getDescription(), event.getEventPlatform(), event.getEventLink(),null);
        savedEvent.setSubclub(subclub);
        return eventRepository.save(savedEvent);
    };
}
