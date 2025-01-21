package com.example.demo.testService;

import com.example.demo.service.SystemService;
import com.example.demo.service.UserService;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.demo.repository.SystemRepository;
import com.example.demo.src_gen.diagrammi_uml.Sistema;
import com.example.demo.src_gen.diagrammi_uml.Utente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@DataJpaTest

class SystemServiceTest {

    @Mock
    private SystemRepository systemRepository;

    @Mock
    private UserService userService;

    @InjectMocks
    private SystemService systemService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegistraSistema() {
        // Arrange
        Sistema sistema = new Sistema();
        sistema.setId(1);

        // Act
        systemService.registraSistema(sistema);

        // Assert
        verify(systemRepository, times(1)).save(sistema);
    }

    @Test
    void testGetById() {
        // Arrange
        Integer sistemaId = 1;
        Sistema sistema = new Sistema();
        sistema.setId(sistemaId);
        when(systemRepository.findById(sistemaId)).thenReturn(Optional.of(sistema));

        // Act
        Optional<Sistema> result = systemService.getById(sistemaId);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(sistema, result.get());
        verify(systemRepository, times(1)).findById(sistemaId);
    }

    @Test
    void testEliminaSistema() {
        // Arrange
        Integer sistemaId = 1;

        // Act
        systemService.eliminaSistema(sistemaId);

        // Assert
        verify(systemRepository, times(1)).deleteById(sistemaId);
    }

    @Test
    void testControllaAbbonamento_True() {
        // Arrange
        Integer utenteId = 1;
        Utente utente = new Utente();
        utente.setId(utenteId);
        utente.setTipo("Premium");
        when(userService.getById(utenteId)).thenReturn(Optional.of(utente));

        // Act
        boolean result = systemService.controllaAbbonamento(utenteId);

        // Assert
        assertTrue(result);
        verify(userService, times(1)).getById(utenteId);
    }

    @Test
    void testControllaAbbonamento_False() {
        // Arrange
        Integer utenteId = 1;
        Utente utente = new Utente();
        utente.setId(utenteId);
        utente.setTipo(null);
        when(userService.getById(utenteId)).thenReturn(Optional.of(utente));

        // Act
        boolean result = systemService.controllaAbbonamento(utenteId);

        // Assert
        assertFalse(result);
        verify(userService, times(1)).getById(utenteId);
    }

    @Test
    void testAddebitaMulta() {
        // Arrange
        Integer utenteId = 1;
        Utente utente = new Utente();
        utente.setId(utenteId);
        utente.setMulta(false);
        when(userService.getById(utenteId)).thenReturn(Optional.of(utente));

        // Act
        systemService.addebitaMulta(utenteId);

        // Assert
        assertTrue(utente.isMulta());
        verify(userService, times(1)).getById(utenteId);
        verify(userService, times(1)).registraUtente(utente);
    }
}
