package com.example.demo.testService;

import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.src_gen.diagrammi_uml.Utente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegistraUtente() {
        // Arrange
        Utente utente = new Utente();
        utente.setNome("Mario");

        // Act
        userService.registraUtente(utente);

        // Assert
        verify(userRepository, times(1)).save(utente);
    }

    @Test
    void testGetById() {
        // Arrange
        Integer userId = 1;
        Utente utente = new Utente();
        utente.setNome("Luisa");
        when(userRepository.findById(userId)).thenReturn(Optional.of(utente));

        // Act
        Optional<Utente> result = userService.getById(userId);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(utente, result.get());
        verify(userRepository, times(1)).findById(userId);
    }

    @Test
    void testEliminaUtente() {
        // Arrange
        Integer userId = 1;

        // Act
        userService.eliminaUtente(userId);

        // Assert
        verify(userRepository, times(1)).deleteById(userId);
    }
}
