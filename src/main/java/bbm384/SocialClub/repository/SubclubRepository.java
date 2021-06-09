package bbm384.SocialClub.repository;

import bbm384.SocialClub.entity.Subclub;
import bbm384.SocialClub.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface SubclubRepository extends JpaRepository<Subclub,Long> {

    @Transactional
    void deleteById(Long id);

    Subclub findByName(String name);
}
