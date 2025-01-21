package com.example.demo.testRepository;

import com.example.demo.DemoApplication;
import com.example.demo.controller.UserController;
import com.example.demo.repository.UserRepository;
import com.example.demo.src_gen.diagrammi_uml.Utente;
import jakarta.transaction.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void checkUtenteName() {
        Utente user = new Utente();
        user.setNome("John");
        user.setCognome("bruganelli");

        Utente savedUser = userRepository.save(user);

        assertNotNull(savedUser.getId());
        assertEquals("John", savedUser.getNome());
        assertEquals("bruganelli", savedUser.getCognome());
    }
}
