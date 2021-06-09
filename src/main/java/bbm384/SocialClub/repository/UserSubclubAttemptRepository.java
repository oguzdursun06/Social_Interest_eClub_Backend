package bbm384.SocialClub.repository;

import bbm384.SocialClub.entity.Subclub;
import bbm384.SocialClub.entity.UserSubclubAttempt;
import bbm384.SocialClub.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserSubclubAttemptRepository extends JpaRepository<UserSubclubAttempt,Long>{

    @Query("select o.subclubId from UserSubclubAttempt o where o.userId = ?1 and o.isJoined = false and o.point >= 50")
    List<Long> findAllCanJoin(Long userId);

    @Query("select o.subclubId from UserSubclubAttempt o where o.userId = ?1 and o.point < 50")
    List<Long> findAllByLessThan(Long id, int point);

    @Query("select o.point from UserSubclubAttempt o where o.userId = ?1 and o.subclubId = ?2")
    int findPoint(Long userId, Long subclubId);

    @Query("select o.subclubId from UserSubclubAttempt o where o.userId = ?1 and o.isJoined = true")
    List<Long> findAllJoinedSubclub(Long id);

    UserSubclubAttempt findBySubclubIdAndUserId(Long subclubId,Long userId);

    @Query("select o.subclubId from UserSubclubAttempt o where o.userId = ?1")
    List<Long> findByUserId(Long userId);

    @Query("select o.userId from UserSubclubAttempt o where o.subclubId = ?1 and o.isJoined = true")
    List<Long> getAllUserFromSubclub(Long subclubId);

    @Query("select o.subclubId from UserSubclubAttempt o where o.userId = ?1")
    List<Long> findAllInterests(Long id);

}
