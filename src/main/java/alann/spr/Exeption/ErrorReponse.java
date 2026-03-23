package alann.spr.Exeption;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorReponse {
    private LocalDateTime timestamp;
    private int status;
    private String message;
    private String path;
    public ErrorReponse() {

    }
}
