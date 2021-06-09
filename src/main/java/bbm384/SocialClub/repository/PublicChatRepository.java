package bbm384.SocialClub.repository;

import bbm384.SocialClub.entity.PublicChat;
import bbm384.SocialClub.entity.Subclub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PublicChatRepository extends JpaRepository<PublicChat, Long> {

        @Query(value = "select * from public_chat where public_chat.subclub_id = ?1",nativeQuery = true)
        List<PublicChat> findAllMessageFromSubclub(Long subclubId);
}
