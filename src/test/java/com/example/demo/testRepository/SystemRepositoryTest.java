package com.example.demo.testRepository;


import com.example.demo.repository.SystemRepository;
import com.example.demo.src_gen.diagrammi_uml.Sensore;
import com.example.demo.src_gen.diagrammi_uml.Sistema;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class SystemRepositoryTest {

    @Autowired
    private SystemRepository systemRepository;

    @Test
    public void testSaveSystem() {
        Sistema sistema = new Sistema();
        sistema.setNome("sistema1");

        Sistema savedSistema = systemRepository.save(sistema);

        assertNotNull(savedSistema.getId());
        assertEquals("sistema1", savedSistema.getNome());
    }
}
