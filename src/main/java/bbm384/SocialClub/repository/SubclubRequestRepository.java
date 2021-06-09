package bbm384.SocialClub.repository;


import bbm384.SocialClub.entity.ClubRequest;
import bbm384.SocialClub.entity.SubclubRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SubclubRequestRepository extends JpaRepository<SubclubRequest,Long> {


    public boolean existsByName(String name);

    public SubclubRequest findByName(String name);

    @Query("select o.clubRequest from SubclubRequest o where o.name = ?1")
    public int findRequestNumber(String name);

    public void deleteByName(String name);
}
