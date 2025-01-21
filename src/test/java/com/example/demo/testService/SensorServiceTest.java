package com.example.demo.testService;

import com.example.demo.service.SensorService;
import com.example.demo.service.VisitatoreService;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


import com.example.demo.repository.SensorRepository;
import com.example.demo.src_gen.diagrammi_uml.Sensore;
import com.example.demo.src_gen.diagrammi_uml.VisitatoreOccasionale;
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
class SensorServiceTest {

    @Mock
    private SensorRepository sensorRepository;

    @Mock
    private VisitatoreService visitatoreService;

    @InjectMocks
    private SensorService sensorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegistraSensore() {
        // Arrange
        Sensore sensore = new Sensore();
        sensore.setId(1);

        // Act
        sensorService.registraSensore(sensore);

        // Assert
        verify(sensorRepository, times(1)).save(sensore);
    }

    @Test
    void testGetById() {
        // Arrange
        Integer sensoreId = 1;
        Sensore sensore = new Sensore();
        sensore.setId(sensoreId);
        when(sensorRepository.findById(sensoreId)).thenReturn(Optional.of(sensore));

        // Act
        Optional<Sensore> result = sensorService.getById(sensoreId);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(sensore, result.get());
        verify(sensorRepository, times(1)).findById(sensoreId);
    }

    @Test
    void testEliminaSensore() {
        // Arrange
        Integer sensoreId = 1;

        // Act
        sensorService.eliminaSensore(sensoreId);

        // Assert
        verify(sensorRepository, times(1)).deleteById(sensoreId);
    }

    @Test
    void testSensoreRileva_Ammesso() {
        // Arrange
        Integer visitatoreId = 1;
        VisitatoreOccasionale visitatore = new VisitatoreOccasionale();
        visitatore.setId(visitatoreId);
        visitatore.setTempo(150);
        when(visitatoreService.getById(visitatoreId)).thenReturn(Optional.of(visitatore));

        // Act
        String result = sensorService.sensoreRileva(visitatoreId);

        // Assert
        assertEquals("Visitatore ancora ammesso", result);
        verify(visitatoreService, times(1)).getById(visitatoreId);
        verify(visitatoreService, never()).registraVisitatore(any());
    }

    @Test
    void testSensoreRileva_Addebitato() {
        // Arrange
        Integer visitatoreId = 1;
        VisitatoreOccasionale visitatore = new VisitatoreOccasionale();
        visitatore.setId(visitatoreId);
        visitatore.setTempo(250);
        visitatore.setSpesa(100);
        when(visitatoreService.getById(visitatoreId)).thenReturn(Optional.of(visitatore));

        // Act
        String result = sensorService.sensoreRileva(visitatoreId);

        // Assert
        assertEquals("Visitatore addebitato!", result);
        assertEquals(150, visitatore.getSpesa());
        verify(visitatoreService, times(1)).getById(visitatoreId);
        verify(visitatoreService, times(1)).registraVisitatore(visitatore);
    }

    @Test
    void testControllaPagamento_True() {
        // Arrange
        Integer visitatoreId = 1;
        VisitatoreOccasionale visitatore = new VisitatoreOccasionale();
        visitatore.setId(visitatoreId);
        visitatore.setPagato(true);
        when(visitatoreService.getById(visitatoreId)).thenReturn(Optional.of(visitatore));

        // Act
        boolean result = sensorService.controllaPagamento(visitatoreId);

        // Assert
        assertTrue(result);
        verify(visitatoreService, times(1)).getById(visitatoreId);
    }

    @Test
    void testControllaPagamento_False() {
        // Arrange
        Integer visitatoreId = 1;
        VisitatoreOccasionale visitatore = new VisitatoreOccasionale();
        visitatore.setId(visitatoreId);
        visitatore.setPagato(false);
        when(visitatoreService.getById(visitatoreId)).thenReturn(Optional.of(visitatore));

        // Act
        boolean result = sensorService.controllaPagamento(visitatoreId);

        // Assert
        assertFalse(result);
        verify(visitatoreService, times(1)).getById(visitatoreId);
    }
}
