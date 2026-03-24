package alann.spr;

import alann.spr.Dto.ReponseDtoEntreprise;
import alann.spr.Dto.RequestDtoEntreprise;
import alann.spr.Entity.Entreprise;
import alann.spr.Service.EntrepriseService;
import alann.spr.mapper.EntrepriseMapper;
import alann.spr.repository.EntrepriseRepository;
import jakarta.validation.constraints.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
public class TestEntrepriseService {
    @Autowired
    private EntrepriseService service;

    @Test
    void testCreateEntreprise() {

        RequestDtoEntreprise dto = new RequestDtoEntreprise();
        dto.setNom("Test Entreprise");
        dto.setContact("123456");
        dto.setLocal("Douala");

        ReponseDtoEntreprise response = service.create(dto);

        assertNotNull(response.getId());
        assertEquals("Test Entreprise", response.getNom());
    }


}
