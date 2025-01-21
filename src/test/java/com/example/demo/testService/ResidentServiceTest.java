package com.example.demo.testService;


import com.example.demo.repository.ResidentRepository;
import com.example.demo.service.ResidentService;
import com.example.demo.src_gen.diagrammi_uml.Residente;
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
class ResidentServiceTest {

    @Mock
    private ResidentRepository residentRepository;

    @InjectMocks
    private ResidentService residentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegistraResidente() {
        // Arrange
        Residente residente = new Residente();
        residente.setId(1);

        // Act
        residentService.registraResidente(residente);

        // Assert
        verify(residentRepository, times(1)).save(residente);
    }

    @Test
    void testGetById() {
        // Arrange
        Integer residenteId = 1;
        Residente residente = new Residente();
        residente.setId(residenteId);
        when(residentRepository.findById(residenteId)).thenReturn(Optional.of(residente));

        // Act
        Optional<Residente> result = residentService.getById(residenteId);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(residente, result.get());
        verify(residentRepository, times(1)).findById(residenteId);
    }

    @Test
    void testGetById_NotFound() {
        // Arrange
        Integer residenteId = 1;
        when(residentRepository.findById(residenteId)).thenReturn(Optional.empty());

        // Act
        Optional<Residente> result = residentService.getById(residenteId);

        // Assert
        assertFalse(result.isPresent());
        verify(residentRepository, times(1)).findById(residenteId);
    }

    @Test
    void testEliminaResidente() {
        // Arrange
        Integer residenteId = 1;

        // Act
        residentService.eliminaResidente(residenteId);

        // Assert
        verify(residentRepository, times(1)).deleteById(residenteId);
    }
}