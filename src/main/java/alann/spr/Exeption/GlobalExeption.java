package alann.spr.Exeption;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExeption {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorReponse> handleException(
            Exception ex, HttpServletRequest request){
        ErrorReponse error = new ErrorReponse();
        error.setPath(request.getRequestURI());
        error.setMessage(ex.getMessage());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    //ressource protege
    @ExceptionHandler(AccessException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)

    public ErrorReponse AccessException(
            AccessException ex,HttpServletRequest request){
        return new ErrorReponse(LocalDateTime.now(),403, ex.getMessage(), request.getRequestURI());
    }

    //exception pour le create
    @ExceptionHandler(CreateException.class)
    public ErrorReponse handlerCreatException(CreateException ex,HttpServletRequest request){
        return new ErrorReponse(LocalDateTime.now(),400, ex.getMessage(), request.getRequestURI());
    }

    //exception pour le read
    @ExceptionHandler(ReadException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorReponse Error(ReadException ex, HttpServletRequest request){
        return new ErrorReponse(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),ex.getMessage(),
                request.getRequestURI()
        );

    }

    //exception  pour le update
    @ExceptionHandler(UpdateException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorReponse UpdateException(UpdateException ex, HttpServletRequest request){
        return new ErrorReponse(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(), ex.getMessage(),
                request.getRequestURI()
        );
    }
    //exception delete
    @ExceptionHandler(DeleteException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorReponse DeleteException(DeleteException ex, HttpServletRequest request) {
        return new ErrorReponse(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(), ex.getMessage(),
                request.getRequestURI()
        );
    }
    //exception get par id et pas recherche
    @ExceptionHandler(GetException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorReponse GetException(GetException ex, HttpServletRequest request) {
        return new ErrorReponse(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(), ex.getMessage(),
                request.getRequestURI()
        );
    }
}
