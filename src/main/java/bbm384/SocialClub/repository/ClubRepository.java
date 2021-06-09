package bbm384.SocialClub.repository;

import bbm384.SocialClub.entity.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface ClubRepository extends JpaRepository<Club,Long> {

    public boolean existsByName(String name);

    @Transactional
    public void deleteById(Long id);



}
