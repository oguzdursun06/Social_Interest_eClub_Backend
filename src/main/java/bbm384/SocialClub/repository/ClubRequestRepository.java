package bbm384.SocialClub.repository;

import bbm384.SocialClub.entity.ClubRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClubRequestRepository extends JpaRepository<ClubRequest,Long> {


    public boolean existsByName(String name);

    public ClubRequest findByName(String name);

    @Query("select o.clubRequest from ClubRequest o where o.name = ?1")
    public int findRequestNumber(String name);

    public void deleteByName(String name);

}
