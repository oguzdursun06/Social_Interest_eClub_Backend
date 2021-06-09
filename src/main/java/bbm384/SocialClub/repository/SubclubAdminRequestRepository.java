package bbm384.SocialClub.repository;

import bbm384.SocialClub.entity.SubclubAdminRequest;
import bbm384.SocialClub.entity.SubclubRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SubclubAdminRequestRepository extends JpaRepository<SubclubAdminRequest,Long> {

    public boolean existsByName(String name);

    public SubclubAdminRequest findByName(String name);

    public void deleteByName(String name);

}
