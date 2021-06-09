package bbm384.SocialClub.exception;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.time.LocalDateTime;
import java.util.Map;

@Data
@RequiredArgsConstructor
public class ApiException {

    private final LocalDateTime timestamp;
    private final Long status;
    private final String httpStatus;
    private final String message;
    private final List<Map<String,String>> errors;




}
