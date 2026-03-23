package alann.spr.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReponseDtoEntreprise {
    private long id;
    private String nom;
    private String contact;
    private String local;
}
