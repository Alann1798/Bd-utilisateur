package alann.spr.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestDtoUser {
    private String nom;
    private String email;
    private String password;
    private Long roleId;
    private Long entrepriseId;




}
