package bbm384.SocialClub.config;

import bbm384.SocialClub.entity.Users;
import bbm384.SocialClub.exception.ApiRequestException;
import bbm384.SocialClub.service.CustomUserDetailsManager;
import bbm384.SocialClub.util.JwtUtil;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtRequestFilter extends OncePerRequestFilter {

    @Value("${security.jwt.secretKey}")
    private String secretKey;

    private final CustomUserDetailsManager customUserDetailsManager;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorization = request.getHeader("Authorization");
        if(authorization != null && authorization.startsWith("Bearer")){
            String jwtToken = authorization.substring(7);
            try {
                String username = JwtUtil.extractUsername(jwtToken, secretKey);
                UserDetails userDetails = (Users) customUserDetailsManager.loadUserByUsername(username);
                var token = new UsernamePasswordAuthenticationToken(userDetails.getUsername(), null, userDetails.getAuthorities());
                token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(token);
            } catch (ExpiredJwtException e) {
                throw new ApiRequestException("Oturum zaman aşımına uğradı");
            }



        }
        filterChain.doFilter(request,response);
    }

}
