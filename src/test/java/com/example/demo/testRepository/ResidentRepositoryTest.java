package com.example.demo.testRepository;

import com.example.demo.repository.ResidentRepository;
import com.example.demo.repository.SystemRepository;
import com.example.demo.src_gen.diagrammi_uml.Residente;
import com.example.demo.src_gen.diagrammi_uml.Sistema;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ResidentRepositoryTest {

    @Autowired
    private ResidentRepository residentRepository;

    @Test
    public void testSaveResident() {
        Residente residente = new Residente();
        residente.setTipo("mensile");

        Residente savedR = residentRepository.save(residente);

        assertNotNull(savedR.getId());
        assertEquals("mensile", savedR.getTipo());
    }

}
