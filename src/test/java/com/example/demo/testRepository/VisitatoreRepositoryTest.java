package com.example.demo.testRepository;

import com.example.demo.repository.VisitatoreRepository;
import com.example.demo.src_gen.diagrammi_uml.VisitatoreOccasionale;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class VisitatoreRepositoryTest {

    @Autowired
    private VisitatoreRepository visitatoreRepository;

    @Test
    public void testSaveVisitatore() {
        VisitatoreOccasionale  visitatore = new VisitatoreOccasionale();
        visitatore.setSpesa(40);

        VisitatoreOccasionale savedV = visitatoreRepository.save(visitatore);

        assertNotNull(savedV.getId());
        assertEquals(Optional.of(40), savedV.getSpesa());
    }
}
