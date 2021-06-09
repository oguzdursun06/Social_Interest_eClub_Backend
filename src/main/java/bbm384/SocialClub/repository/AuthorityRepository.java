package bbm384.SocialClub.repository;

import bbm384.SocialClub.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface AuthorityRepository extends JpaRepository<Authority,Long> {

    Authority findByUsername(String username);

    void deleteByUsername(String username);
}
