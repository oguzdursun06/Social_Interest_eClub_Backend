package bbm384.SocialClub.repository;

import bbm384.SocialClub.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventRepository extends JpaRepository<Event,Long> {

    @Query(value = "select * from Event e where e.subclub_id = ?1",nativeQuery = true)
    List<Event> getAllEvents(Long subclubId);

}
