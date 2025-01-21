package com.example.demo.testRepository;

import com.example.demo.repository.SensorRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.src_gen.diagrammi_uml.Sensore;
import com.example.demo.src_gen.diagrammi_uml.Utente;
import jakarta.transaction.Transactional;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class SensorRepositoryTest {

    @Autowired
    private SensorRepository sensorRepository;

    @Test
    public void testSaveSensor() {
        Sensore sensore = new Sensore();
        sensore.setNome("sensore1");

        Sensore savedSensore = sensorRepository.save(sensore);

        assertNotNull(savedSensore.getId());
        assertEquals("sensore1", savedSensore.getNome());
    }
}
