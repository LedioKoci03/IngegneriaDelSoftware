package com.example.demo.testService;

import com.example.demo.repository.VisitatoreRepository;
import com.example.demo.service.VisitatoreService;
import com.example.demo.src_gen.diagrammi_uml.VisitatoreOccasionale;
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
class VisitatoreServiceTest {

    @Mock
    private VisitatoreRepository visitatoreRepository;

    @InjectMocks
    private VisitatoreService visitatoreService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegistraVisitatore() {
        // Arrange
        VisitatoreOccasionale visitatore = new VisitatoreOccasionale();
        visitatore.setId(1);
        visitatore.setSpesa(0);
        visitatore.setPagato(false);

        // Act
        visitatoreService.registraVisitatore(visitatore);

        // Assert
        verify(visitatoreRepository, times(1)).save(visitatore);
    }

    @Test
    void testGetById() {
        // Arrange
        Integer visitatoreId = 1;
        VisitatoreOccasionale visitatore = new VisitatoreOccasionale();
        visitatore.setId(visitatoreId);
        visitatore.setSpesa(100);
        when(visitatoreRepository.findById(visitatoreId)).thenReturn(Optional.of(visitatore));

        // Act
        Optional<VisitatoreOccasionale> result = visitatoreService.getById(visitatoreId);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(visitatore, result.get());
        verify(visitatoreRepository, times(1)).findById(visitatoreId);
    }

    @Test
    void testEliminaVisitatore() {
        // Arrange
        Integer visitatoreId = 1;

        // Act
        visitatoreService.eliminaVisitatore(visitatoreId);

        // Assert
        verify(visitatoreRepository, times(1)).deleteById(visitatoreId);
    }

    @Test
    void testPagaTariffa() {
        // Arrange
        Integer visitatoreId = 1;
        VisitatoreOccasionale visitatore = new VisitatoreOccasionale();
        visitatore.setId(visitatoreId);
        visitatore.setSpesa(100);
        visitatore.setPagato(false);

        when(visitatoreRepository.findById(visitatoreId)).thenReturn(Optional.of(visitatore));

        // Act
        visitatoreService.pagaTariffa(visitatoreId);

        // Assert
        assertEquals(125, visitatore.getSpesa()); // Spesa incremented by 25
        assertTrue(visitatore.isPagato());        // Pagato set to true
        verify(visitatoreRepository, times(1)).findById(visitatoreId);
        verify(visitatoreRepository, times(1)).save(visitatore);
    }
}