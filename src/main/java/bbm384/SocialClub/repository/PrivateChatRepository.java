package bbm384.SocialClub.repository;

import bbm384.SocialClub.entity.PrivateChat;
import bbm384.SocialClub.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PrivateChatRepository extends JpaRepository<PrivateChat,Long> {

    @Query(value = "SELECT d FROM PrivateChat d")
    public PrivateChat get();


}
