package bbm384.SocialClub.service;

import bbm384.SocialClub.dto.login.LoginRequestDTO;
import bbm384.SocialClub.dto.login.LoginResponseDTO;
import bbm384.SocialClub.exception.ApiRequestException;
import bbm384.SocialClub.repository.UsersRepository;
import bbm384.SocialClub.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final DaoAuthenticationProvider authenticationProvider;
    private final UsersRepository usersRepository;

    @Value("${security.jwt.secretKey}")
    private String secretKey;


    public LoginResponseDTO login(LoginRequestDTO loginRequest) {
        if(usersRepository.existsByUsername(loginRequest.getUsername()) == false){
            throw new ApiRequestException("User not found");
        }
        Authentication authentication = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword());
        try {
            Authentication user = authenticationProvider.authenticate(authentication);
            String token = JwtUtil.generateToken(user,secretKey, 1);
            return new LoginResponseDTO(token,loginRequest.getUsername());
        } catch (BadCredentialsException e){
            throw new ApiRequestException("Kullanıcı adı veya şifre yanlış");
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        return null;
    }

    public char[] generatePassword(int length) {
        String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String specialCharacters = "!@#$";
        String numbers = "1234567890";
        String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
        Random random = new Random();
        char[] password = new char[length];

        password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
        password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
        password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
        password[3] = numbers.charAt(random.nextInt(numbers.length()));

        for(int i = 4; i< length ; i++) {
            password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
        }
        return password;
    }
}
