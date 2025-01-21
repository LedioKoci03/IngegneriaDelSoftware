package com.example.demo.testRepository;

import com.example.demo.repository.VisitatoreRepository;
import com.example.demo.src_gen.diagrammi_uml.VisitatoreOccasionale;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class VisitatoreRepositoryTest {

    @Autowired
    private VisitatoreRepository visitatoreRepository;

    @Test
    public void testSaveVisitatore() {
        VisitatoreOccasionale  visitatore = new VisitatoreOccasionale();
        visitatore.setPagato(true);

        VisitatoreOccasionale savedV = visitatoreRepository.save(visitatore);

        assertNotNull(savedV.getId());
        assertTrue(savedV.pagato);
    }
}
