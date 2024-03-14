package com.hackaton.postech.application.controller;

import com.hackaton.postech.domain.dto.request.QuartoRequestDTO;
import com.hackaton.postech.domain.dto.response.QuartoResponseDTO;
import com.hackaton.postech.useCase.contract.IQuartoService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class QuartoControllerTest {

    @Mock
    private IQuartoService quartoService;

    @InjectMocks
    private QuartoController quartoController;

    public QuartoControllerTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAll() {
        when(quartoService.getAll()).thenReturn(Arrays.asList(new QuartoResponseDTO(), new QuartoResponseDTO()));
        List<QuartoResponseDTO> result = quartoController.getAll();
        verify(quartoService, times(1)).getAll();
        assertEquals(2, result.size());
    }

    @Test
    public void testGetById() {
        Long id = 1L;
        QuartoResponseDTO expectedQuarto = new QuartoResponseDTO();
        when(quartoService.getById(id)).thenReturn(expectedQuarto);
        QuartoResponseDTO result = quartoController.getById(id);
        verify(quartoService, times(1)).getById(id);
        assertNotNull(result);
        assertEquals(expectedQuarto, result);
    }

    @Test
    public void testCreate() {
        QuartoRequestDTO quartoRequest = new QuartoRequestDTO();
        QuartoResponseDTO expectedQuarto = new QuartoResponseDTO();
        when(quartoService.create(quartoRequest)).thenReturn(expectedQuarto);
        QuartoResponseDTO result = quartoController.create(quartoRequest);
        verify(quartoService, times(1)).create(quartoRequest);
        assertNotNull(result);
        assertEquals(expectedQuarto, result);
    }

    @Test
    public void testUpdate() {
        Long id = 1L;
        QuartoRequestDTO quartoRequest = new QuartoRequestDTO();
        QuartoResponseDTO expectedQuarto = new QuartoResponseDTO();
        when(quartoService.update(id, quartoRequest)).thenReturn(expectedQuarto);
        QuartoResponseDTO result = quartoController.update(id, quartoRequest);
        verify(quartoService, times(1)).update(id, quartoRequest);
        assertNotNull(result);
        assertEquals(expectedQuarto, result);
    }

    @Test
    public void testDeleteById() {
        Long id = 1L;
        quartoController.deleteById(id);
        verify(quartoService, times(1)).deleteById(id);
    }
}

