package bbm384.SocialClub.util;

import bbm384.SocialClub.entity.Authority;
import bbm384.SocialClub.entity.Users;
import bbm384.SocialClub.repository.AuthorityRepository;
import bbm384.SocialClub.repository.UsersRepository;
import bbm384.SocialClub.service.CustomUserDetailsManager;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class DatabasePopulator {

    private final CustomUserDetailsManager customUserDetailsManager;
    private final AuthorityRepository authorityRepository;

    @Transactional
    public void populateDatabase(){
/*
        Users adminUser = new Users(null, "SYSTEM", "ADMIN", "admin", "02.01.1976","admin@edu.tr", "admin", true, List.of(new Authority(null, "admin", "ADMIN")));
        Users normalUser = new Users(null, "İlk", "Kullanıcı", "user", "07.11.1994","user@gmail.com", "user", true, List.of(new Authority(null, "user", "USER")));


        customUserDetailsManager.createUser(adminUser);
        customUserDetailsManager.createUser(normalUser);

*/

    }

}
