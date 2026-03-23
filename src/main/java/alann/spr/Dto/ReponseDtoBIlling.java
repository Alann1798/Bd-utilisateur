package alann.spr.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReponseDtoBIlling {
    private Long id;
    private int quantite;
    private double prix;
    private double montant;
    private String customerNom;
    private String entrepriseNom;
}
