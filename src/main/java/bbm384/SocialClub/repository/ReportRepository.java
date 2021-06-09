package bbm384.SocialClub.repository;

import bbm384.SocialClub.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report,Long> {


    @Query("select o from Report o where o.type = 'subadmin'")
    public List<Report> getAllSubReport();

    @Query("select o from Report o where o.type = 'user'")
    public List<Report> getAllUserReport();
}
