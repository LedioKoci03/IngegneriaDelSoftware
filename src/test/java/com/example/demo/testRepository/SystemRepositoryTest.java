package com.example.demo.testRepository;


import com.example.demo.repository.SystemRepository;
import com.example.demo.src_gen.diagrammi_uml.Sistema;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
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
