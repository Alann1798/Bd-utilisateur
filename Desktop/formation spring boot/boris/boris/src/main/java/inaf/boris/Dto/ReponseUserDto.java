package inaf.boris.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReponseUserDto {
    private Long Id;
    private String nom;
    private String email;
}
