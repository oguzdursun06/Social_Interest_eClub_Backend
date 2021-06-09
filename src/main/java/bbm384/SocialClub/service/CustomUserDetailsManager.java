package bbm384.SocialClub.service;

import bbm384.SocialClub.entity.Users;
import bbm384.SocialClub.exception.ApiRequestException;
import bbm384.SocialClub.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsManager implements UserDetailsManager {

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void createUser(UserDetails userDetails) {
        Users users = (Users) userDetails;
        if (usersRepository.existsByUsername(users.getUsername())) {
            throw new ApiRequestException("Kullanıcı adı daha önce kullanıldı!");
        }
        else{
            users.setPassword(passwordEncoder.encode(userDetails.getPassword()));
            usersRepository.save(users);
        }
    }

    @Override
    public void updateUser(UserDetails userDetails) {
        Users oldUser = (Users) loadUserByUsername(userDetails.getUsername());
        Users newUser = (Users) userDetails;
        newUser.setId(oldUser.getId());
        usersRepository.save(newUser);
    }

    @Override
    public void deleteUser(String username) {
            usersRepository.deleteByUsername(username);
    }

    @Override
    public void changePassword(String s, String s1) {

    }

    @Override
    public boolean userExists(String username) {
        return usersRepository.existsByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usersRepository.findByUsername(username);
    }
}
