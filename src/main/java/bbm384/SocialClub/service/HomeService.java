package bbm384.SocialClub.service;

import bbm384.SocialClub.dto.user.ForgetPasswordDTO;
import bbm384.SocialClub.entity.Users;
import bbm384.SocialClub.repository.ClubRepository;
import bbm384.SocialClub.repository.SubclubRepository;
import bbm384.SocialClub.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@RequiredArgsConstructor
@Service
public class HomeService {

    private final PasswordEncoder passwordEncoder;
    private final LoginService loginService;
    private final UsersRepository usersRepository;

    public void forgetPassword(ForgetPasswordDTO forgetPasswordDTO){
        EmailService emailService = new EmailService();
        Users emailOwner = usersRepository.findByEmail(forgetPasswordDTO.getEmail());
        String password = new String(loginService.generatePassword(8));
        emailOwner.setPassword(passwordEncoder.encode(password));
        usersRepository.save(emailOwner);

        emailService.sendEmail(forgetPasswordDTO.getEmail(),emailOwner.getFirstName(),emailOwner.getLastName(),password);
    }
}
