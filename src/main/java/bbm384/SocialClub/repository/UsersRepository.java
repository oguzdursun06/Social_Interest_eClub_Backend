package bbm384.SocialClub.repository;

import bbm384.SocialClub.entity.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users,Long> {


    Users findByUsername(String username);

    Optional<Users> findById(Long id);

    @Transactional
    void deleteByUsername(String username);

    boolean existsByUsername(String username);

    Users findByEmail(String email);

    @Query("select o from Users o where o.username != 'admin'")
    List<Users> getAllUsers();

}
