package com.example.demo.testController;

import com.example.demo.controller.VisitatoreController;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.service.VisitatoreService;
import com.example.demo.src_gen.diagrammi_uml.VisitatoreOccasionale;
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
class VisitatoreControllerTest {

    private VisitatoreService visitatoreService;
    private VisitatoreController visitatoreController;

    @BeforeEach
    void setUp() {
        visitatoreService = Mockito.mock(VisitatoreService.class);
        visitatoreController = new VisitatoreController(visitatoreService);
    }

    @Test
    void testRegistraVisitatore_Success() {
        // Arrange
        VisitatoreOccasionale visitatore = new VisitatoreOccasionale();
        doNothing().when(visitatoreService).registraVisitatore(visitatore);

        // Act
        ResponseEntity<?> response = visitatoreController.registraVisitatore(visitatore);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Visitatore registrato!", response.getBody());
        verify(visitatoreService, times(1)).registraVisitatore(visitatore);
    }

    @Test
    void testGetUserById_Success() {
        // Arrange
        Integer visitatoreId = 1;
        VisitatoreOccasionale visitatore = new VisitatoreOccasionale();
        visitatore.setId(visitatoreId);
        when(visitatoreService.getById(visitatoreId)).thenReturn(Optional.of(visitatore));

        // Act
        ResponseEntity<Optional<VisitatoreOccasionale>> response = visitatoreController.getUserById(visitatoreId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(visitatore, response.getBody().orElse(null));
        verify(visitatoreService, times(1)).getById(visitatoreId);
    }

    @Test
    void testGetUserById_NotFound() {
        // Arrange
        Integer visitatoreId = 1;
        when(visitatoreService.getById(visitatoreId)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<Optional<VisitatoreOccasionale>> response = visitatoreController.getUserById(visitatoreId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(Optional.empty(), response.getBody());
        verify(visitatoreService, times(1)).getById(visitatoreId);
    }

    @Test
    void testEliminaVisitatore_Success() {
        // Arrange
        Integer visitatoreId = 1;
        doNothing().when(visitatoreService).eliminaVisitatore(visitatoreId);

        // Act
        ResponseEntity<?> response = visitatoreController.eliminaVisitatore(visitatoreId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Visitatore eliminato!", response.getBody());
        verify(visitatoreService, times(1)).eliminaVisitatore(visitatoreId);
    }

    @Test
    void testPagaTariffa_Success() {
        // Arrange
        Integer visitatoreId = 1;
        doNothing().when(visitatoreService).pagaTariffa(visitatoreId);

        // Act
        ResponseEntity<?> response = visitatoreController.pagaTariffa(visitatoreId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Tariffa pagata!", response.getBody());
        verify(visitatoreService, times(1)).pagaTariffa(visitatoreId);
    }
}
