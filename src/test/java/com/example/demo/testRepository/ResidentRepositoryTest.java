package com.example.demo.testRepository;

import com.example.demo.repository.ResidentRepository;
import com.example.demo.repository.SystemRepository;
import com.example.demo.src_gen.diagrammi_uml.Residente;
import com.example.demo.src_gen.diagrammi_uml.Sistema;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
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
