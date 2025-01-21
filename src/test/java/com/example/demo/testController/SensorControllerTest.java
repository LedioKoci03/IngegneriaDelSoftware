package com.example.demo.testController;

import com.example.demo.controller.SensorController;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.service.SensorService;
import com.example.demo.src_gen.diagrammi_uml.Sensore;
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
class SensorControllerTest {

    private SensorService sensorService;
    private SensorController sensorController;

    @BeforeEach
    void setUp() {
        sensorService = Mockito.mock(SensorService.class);
        sensorController = new SensorController(sensorService);
    }

    @Test
    void testRegistraSensore_Success() {
        // Arrange
        Sensore sensore = new Sensore();
        doNothing().when(sensorService).registraSensore(sensore);

        // Act
        ResponseEntity<?> response = sensorController.registraSensore(sensore);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Sensore registrato!", response.getBody());
        verify(sensorService, times(1)).registraSensore(sensore);
    }

    @Test
    void testGetById_Success() {
        // Arrange
        Integer sensoreId = 1;
        Sensore sensore = new Sensore();
        sensore.setId(sensoreId);
        when(sensorService.getById(sensoreId)).thenReturn(Optional.of(sensore));

        // Act
        ResponseEntity<Optional<Sensore>> response = sensorController.getById(sensoreId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(sensore, response.getBody().orElse(null));
        verify(sensorService, times(1)).getById(sensoreId);
    }

    @Test
    void testGetById_NotFound() {
        // Arrange
        Integer sensoreId = 1;
        when(sensorService.getById(sensoreId)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<Optional<Sensore>> response = sensorController.getById(sensoreId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(Optional.empty(), response.getBody());
        verify(sensorService, times(1)).getById(sensoreId);
    }

    @Test
    void testSensoreRileva_Success() {
        // Arrange
        Integer sensoreId = 1;
        String expectedMessage = "Sensore rileva movimento.";
        when(sensorService.sensoreRileva(sensoreId)).thenReturn(expectedMessage);

        // Act
        ResponseEntity<?> response = sensorController.sensoreRileva(sensoreId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedMessage, response.getBody());
        verify(sensorService, times(1)).sensoreRileva(sensoreId);
    }

    @Test
    void testEliminaSensore_Success() {
        // Arrange
        Integer sensoreId = 1;
        doNothing().when(sensorService).eliminaSensore(sensoreId);

        // Act
        ResponseEntity<?> response = sensorController.eliminaSensore(sensoreId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Sensore eliminato!", response.getBody());
        verify(sensorService, times(1)).eliminaSensore(sensoreId);
    }

    @Test
    void testControllaPagamento_Effettuato() {
        // Arrange
        Integer sensoreId = 1;
        when(sensorService.controllaPagamento(sensoreId)).thenReturn(true);

        // Act
        ResponseEntity<?> response = sensorController.controllaPagamento(sensoreId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Pagamento effettuato!", response.getBody());
        verify(sensorService, times(1)).controllaPagamento(sensoreId);
    }

    @Test
    void testControllaPagamento_NonEffettuato() {
        // Arrange
        Integer sensoreId = 1;
        when(sensorService.controllaPagamento(sensoreId)).thenReturn(false);

        // Act
        ResponseEntity<?> response = sensorController.controllaPagamento(sensoreId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Pagamento non effettuato!", response.getBody());
        verify(sensorService, times(1)).controllaPagamento(sensoreId);
    }
}
