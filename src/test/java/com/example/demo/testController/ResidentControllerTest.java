package com.example.demo.testController;

import com.example.demo.controller.ResidentController;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.service.ResidentService;
import com.example.demo.src_gen.diagrammi_uml.Residente;
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
class ResidentControllerTest {

    private ResidentService residentService;
    private ResidentController residentController;

    @BeforeEach
    void setUp() {
        residentService = Mockito.mock(ResidentService.class);
        residentController = new ResidentController(residentService);
    }

    @Test
    void testRegistraResidente_Success() {
        // Arrange
        Residente residente = new Residente();
        doNothing().when(residentService).registraResidente(residente);

        // Act
        ResponseEntity<?> response = residentController.registraUtente(residente);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Residente registrato!", response.getBody());
        verify(residentService, times(1)).registraResidente(residente);
    }

    @Test
    void testGetById_Success() {
        // Arrange
        Integer residenteId = 1;
        Residente residente = new Residente();
        residente.setId(residenteId);
        when(residentService.getById(residenteId)).thenReturn(Optional.of(residente));

        // Act
        ResponseEntity<Optional<Residente>> response = residentController.getById(residenteId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(residente, response.getBody().orElse(null));
        verify(residentService, times(1)).getById(residenteId);
    }

    @Test
    void testGetById_NotFound() {
        // Arrange
        Integer residenteId = 1;
        when(residentService.getById(residenteId)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<Optional<Residente>> response = residentController.getById(residenteId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(Optional.empty(), response.getBody());
        verify(residentService, times(1)).getById(residenteId);
    }

    @Test
    void testEliminaResidente_Success() {
        // Arrange
        Integer residenteId = 1;
        doNothing().when(residentService).eliminaResidente(residenteId);

        // Act
        ResponseEntity<?> response = residentController.eliminaUtente(residenteId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Residente eliminato!", response.getBody());
        verify(residentService, times(1)).eliminaResidente(residenteId);
    }
}
