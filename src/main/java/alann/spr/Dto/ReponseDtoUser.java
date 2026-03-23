package alann.spr.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReponseDtoUser {
    private long  id;
    private  String Nom;
    private  String email;
    private String roleNom;
    private String entrepriseNom;


}
