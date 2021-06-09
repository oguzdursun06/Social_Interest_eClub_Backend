package bbm384.SocialClub.controller;


import bbm384.SocialClub.dto.login.LoginRequestDTO;
import bbm384.SocialClub.dto.login.LoginResponseDTO;
import bbm384.SocialClub.dto.user.ForgetPasswordDTO;
import bbm384.SocialClub.dto.user.SignUpDTO;
import bbm384.SocialClub.entity.Authority;
import bbm384.SocialClub.entity.Club;
import bbm384.SocialClub.entity.Subclub;
import bbm384.SocialClub.entity.Users;
import bbm384.SocialClub.repository.ClubRepository;
import bbm384.SocialClub.repository.SubclubRepository;
import bbm384.SocialClub.repository.UsersRepository;
import bbm384.SocialClub.service.CustomUserDetailsManager;
import bbm384.SocialClub.service.EmailService;
import bbm384.SocialClub.service.HomeService;
import bbm384.SocialClub.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class HomeController {

    private final LoginService loginService;
    private final CustomUserDetailsManager customUserDetailsManager;
    private final ClubRepository clubRepository;
    private final SubclubRepository subclubRepository;
    private final UsersRepository usersRepository;

    private final HomeService homeService;

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO loginRequest) {
        return loginService.login(loginRequest);
    }

    @PostMapping("/signUp")
    public void signUp(@Valid @RequestBody SignUpDTO signUpDTO){
        Users newUser = new Users(null, signUpDTO.getFirstName(), signUpDTO.getLastName(), signUpDTO.getUsername(), signUpDTO.getBirthDate(), signUpDTO.getEmail(), signUpDTO.getPassword(), true, List.of(new Authority(null, signUpDTO.getUsername(), "USER")));
        customUserDetailsManager.createUser(newUser);
    }

    @PostMapping("/forgetPassword")
    public void forgetPassword(@Valid @RequestBody ForgetPasswordDTO forgetPasswordDTO){
        homeService.forgetPassword(forgetPasswordDTO);
    }

    @GetMapping("/hello")
    public String hello(){
        return "Welcome to Spring Security";
    }

    @GetMapping("/clubs")
    @PreAuthorize("permitAll()")
    public List<Club> listAllClubs(){
        return clubRepository.findAll();
    }

    @GetMapping("/subclubs")
    @PreAuthorize("permitAll()")
    public List<Subclub> listAllSubclubs(){
        return subclubRepository.findAll();
    }

    @GetMapping("/users")
    @PreAuthorize("permitAll()")
    public List<Users> listAllUsers(){
        return usersRepository.findAll();
    }


    /*
    @GetMapping("/get/{username}")
    @PreAuthorize("permitAll()")
    public List<Subclub> difference(@PathVariable String username){
        List<Subclub> differences = subclubRepository.findAll().stream()
                .filter(element -> !usersRepository.findByUsername(username).getSubclubs().contains(element))
                .collect(Collectors.toList());
        return differences;
    }


    @GetMapping("/bak")
    @PreAuthorize("permitAll()")
    public List<Subclub> bakalım(){
        List<Subclub> subclubs = usersRepository.findById(2L).get().getSubclubs();
        return subclubs;
    }

*/




}
