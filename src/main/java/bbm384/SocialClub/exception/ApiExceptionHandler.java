package bbm384.SocialClub.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e){
        ApiException apiException = new ApiException(LocalDateTime.now(),400L,
                "Bad Request","", List.of(Map.of("defaultMessage",e.getMessage()))
        );
        return new ResponseEntity<>(apiException,HttpStatus.BAD_REQUEST);
    }
}
