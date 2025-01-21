package com.example.demo.testController;

import com.example.demo.controller.UserController;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.http.ResponseEntity.ok;

import com.example.demo.service.UserService;
import com.example.demo.src_gen.diagrammi_uml.Utente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegistraUtente() {
        // Arrange
        Utente utente = new Utente();
        utente.setId(1);

        // Act
        ResponseEntity<?> response = userController.registraUtente(utente);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Utente registrato!", response.getBody());
        verify(userService, times(1)).registraUtente(utente);
    }

    @Test
    void testGetUserById() {

        // Arrange
        Integer userId = 1;
        Utente utente = new Utente();
        utente.setId(userId);
        when(userService.getById(userId)).thenReturn(Optional.of(utente));

        // Act
        ResponseEntity<Optional<Utente>> response = userController.getUserById(userId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().isPresent());
        assertEquals(utente, response.getBody().get());

        // Verify interaction
        verify(userService, times(1)).getById(userId);
    }

    @Test
    void testEliminaUtente() {
        // Arrange
        Integer userId = 1;

        // Act
        ResponseEntity<?> response = userController.eliminaUtente(userId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Utente eliminato!", response.getBody());
        verify(userService, times(1)).eliminaUtente(userId);
    }
}
