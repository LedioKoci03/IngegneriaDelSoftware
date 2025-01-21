package com.example.demo.testController;

import com.example.demo.controller.SystemController;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.service.SystemService;
import com.example.demo.src_gen.diagrammi_uml.Sistema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class SystemControllerTest {

    private SystemService systemService;
    private SystemController systemController;

    @BeforeEach
    void setUp() {
        systemService = Mockito.mock(SystemService.class);
        systemController = new SystemController(systemService);
    }

    @Test
    void testRegistraSistema_Success() {
        // Arrange
        Sistema sistema = new Sistema();
        doNothing().when(systemService).registraSistema(sistema);

        // Act
        ResponseEntity<?> response = systemController.registraSistema(sistema);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Sistema registrato!", response.getBody());
        verify(systemService, times(1)).registraSistema(sistema);
    }

    @Test
    void testGetUserById_Success() {
        // Arrange
        Integer sistemaId = 1;
        Sistema sistema = new Sistema();
        sistema.setId(sistemaId);
        when(systemService.getById(sistemaId)).thenReturn(Optional.of(sistema));

        // Act
        ResponseEntity<Optional<Sistema>> response = systemController.getUserById(sistemaId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(sistema, response.getBody().orElse(null));
        verify(systemService, times(1)).getById(sistemaId);
    }

    @Test
    void testGetUserById_NotFound() {
        // Arrange
        Integer sistemaId = 1;
        when(systemService.getById(sistemaId)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<Optional<Sistema>> response = systemController.getUserById(sistemaId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(Optional.empty(), response.getBody());
        verify(systemService, times(1)).getById(sistemaId);
    }

    @Test
    void testEliminaSistema_Success() {
        // Arrange
        Integer sistemaId = 1;
        doNothing().when(systemService).eliminaSistema(sistemaId);

        // Act
        ResponseEntity<?> response = systemController.eliminaSistema(sistemaId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Sistema eliminato!", response.getBody());
        verify(systemService, times(1)).eliminaSistema(sistemaId);
    }

    @Test
    void testControllaAbbonamento_Presente() {
        // Arrange
        Integer sistemaId = 1;
        when(systemService.controllaAbbonamento(sistemaId)).thenReturn(true);

        // Act
        ResponseEntity<?> response = systemController.controllaAbbonamento(sistemaId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Abbonamento presente!", response.getBody());
        verify(systemService, times(1)).controllaAbbonamento(sistemaId);
        verify(systemService, never()).addebitaMulta(sistemaId);
    }

    @Test
    void testControllaAbbonamento_NonPresente() {
        // Arrange
        Integer sistemaId = 1;
        when(systemService.controllaAbbonamento(sistemaId)).thenReturn(false);
        doNothing().when(systemService).addebitaMulta(sistemaId);

        // Act
        ResponseEntity<?> response = systemController.controllaAbbonamento(sistemaId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Abbonamento non presente, addebito multa!", response.getBody());
        verify(systemService, times(1)).controllaAbbonamento(sistemaId);
        verify(systemService, times(1)).addebitaMulta(sistemaId);
    }
}
