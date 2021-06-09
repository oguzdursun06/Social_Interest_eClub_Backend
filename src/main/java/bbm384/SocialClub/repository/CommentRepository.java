package bbm384.SocialClub.repository;


import bbm384.SocialClub.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {


    @Query(value = "select * from Comment o where o.subclub_id = ?1",nativeQuery = true)
    public List<Comment> getSubclubComment(Long subclubId);
}
