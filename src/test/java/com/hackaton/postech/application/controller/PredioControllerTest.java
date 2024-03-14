package com.hackaton.postech.application.controller;

import com.hackaton.postech.domain.dto.request.PredioRequestDTO;
import com.hackaton.postech.domain.dto.response.PredioResponseDTO;
import com.hackaton.postech.useCase.contract.IPredioService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class PredioControllerTest {

    @Mock
    private IPredioService predioService;

    @InjectMocks
    private PredioController predioController;

    public PredioControllerTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAll() {
        when(predioService.getAll()).thenReturn(Arrays.asList(new PredioResponseDTO(), new PredioResponseDTO()));
        List<PredioResponseDTO> result = predioController.getAll();
        verify(predioService, times(1)).getAll();
        assertEquals(2, result.size());
    }

    @Test
    public void testGetById() {
        Long id = 1L;
        PredioResponseDTO expectedPredio = new PredioResponseDTO();
        when(predioService.getById(id)).thenReturn(expectedPredio);
        PredioResponseDTO result = predioController.getById(id);
        verify(predioService, times(1)).getById(id);
        assertNotNull(result);
        assertEquals(expectedPredio, result);
    }

    @Test
    public void testCreate() {
        PredioRequestDTO predioRequest = new PredioRequestDTO();
        PredioResponseDTO expectedPredio = new PredioResponseDTO();
        when(predioService.create(predioRequest)).thenReturn(expectedPredio);
        PredioResponseDTO result = predioController.create(predioRequest);
        verify(predioService, times(1)).create(predioRequest);
        assertNotNull(result);
        assertEquals(expectedPredio, result);
    }

    @Test
    public void testUpdate() {
        Long id = 1L;
        PredioRequestDTO predioRequest = new PredioRequestDTO();
        PredioResponseDTO expectedPredio = new PredioResponseDTO();
        when(predioService.update(id, predioRequest)).thenReturn(expectedPredio);
        PredioResponseDTO result = predioController.update(id, predioRequest);
        verify(predioService, times(1)).update(id, predioRequest);
        assertNotNull(result);
        assertEquals(expectedPredio, result);
    }

    @Test
    public void testDeleteById() {
        Long id = 1L;
        predioController.deleteById(id);
        verify(predioService, times(1)).deleteById(id);
    }
}

