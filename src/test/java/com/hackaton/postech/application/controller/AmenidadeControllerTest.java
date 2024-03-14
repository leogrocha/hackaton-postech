package com.hackaton.postech.application.controller;

import com.hackaton.postech.application.controller.AmenidadeController;
import com.hackaton.postech.domain.dto.request.AmenidadeRequestDTO;
import com.hackaton.postech.domain.dto.response.AmenidadeResponseDTO;
import com.hackaton.postech.useCase.contract.IAmenidadeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AmenidadeControllerTest {

    @Mock
    private IAmenidadeService amenidadeService;

    @InjectMocks
    private AmenidadeController amenidadeController;

    public AmenidadeControllerTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAll() {
        when(amenidadeService.getAll()).thenReturn(Arrays.asList(new AmenidadeResponseDTO(), new AmenidadeResponseDTO()));

        List<AmenidadeResponseDTO> result = amenidadeController.getAll();

        verify(amenidadeService, times(1)).getAll();

        assertEquals(2, result.size());
    }

    @Test
    public void testGetById() {
        Long id = 1L;
        AmenidadeResponseDTO expectedAmenidade = new AmenidadeResponseDTO();
        when(amenidadeService.getById(id)).thenReturn(expectedAmenidade);

        AmenidadeResponseDTO result = amenidadeController.getById(id);

        verify(amenidadeService, times(1)).getById(id);

        assertNotNull(result);
        assertEquals(expectedAmenidade, result);
    }

    @Test
    public void testCreate() {
        AmenidadeRequestDTO amenidadeRequest = new AmenidadeRequestDTO();
        AmenidadeResponseDTO expectedAmenidade = new AmenidadeResponseDTO();
        when(amenidadeService.create(amenidadeRequest)).thenReturn(expectedAmenidade);

        AmenidadeResponseDTO result = amenidadeController.create(amenidadeRequest);

        verify(amenidadeService, times(1)).create(amenidadeRequest);

        assertNotNull(result);
        assertEquals(expectedAmenidade, result);
    }

    @Test
    public void testUpdate() {
        Long id = 1L;
        AmenidadeRequestDTO amenidadeRequest = new AmenidadeRequestDTO();
        AmenidadeResponseDTO expectedAmenidade = new AmenidadeResponseDTO();
        when(amenidadeService.update(id, amenidadeRequest)).thenReturn(expectedAmenidade);

        AmenidadeResponseDTO result = amenidadeController.update(id, amenidadeRequest);

        verify(amenidadeService, times(1)).update(id, amenidadeRequest);

        assertNotNull(result);
        assertEquals(expectedAmenidade, result);
    }

    @Test
    public void testDeleteById() {
        Long id = 1L;
        amenidadeController.deleteById(id);

        verify(amenidadeService, times(1)).deleteById(id);
    }

}

