package alann.spr;

import alann.spr.Entity.Entreprise;
import alann.spr.repository.EntrepriseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@ActiveProfiles("test")
@DataJpaTest
public class EntrepriseRepositoryTest {

    @Autowired
    private EntrepriseRepository repository;

    @Test
    void testCreateEntreprise() {

            // CREATE
            Entreprise ent= new Entreprise();
            ent.setNom("Test Entreprise");
            ent.setContact("123456");
            ent.setLocal("Douala");

            Entreprise save = repository.save(ent);

            // ASSERT
           assertNotNull(save);
            assertNotNull(save.getId());
            assertEquals("Test Entreprise", save.getNom());
        }
}
