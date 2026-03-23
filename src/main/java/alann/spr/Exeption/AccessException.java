package alann.spr.Exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class AccessException extends RuntimeException{
        public AccessException(String message) {
            super(message);
        }
    }

