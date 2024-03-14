package com.hackaton.postech.application.controller;

import com.hackaton.postech.domain.dto.request.MovelRequestDTO;
import com.hackaton.postech.domain.dto.response.MovelResponseDTO;
import com.hackaton.postech.useCase.contract.IMovelService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class MovelControllerTest {

    @Mock
    private IMovelService movelService;

    @InjectMocks
    private MovelController movelController;

    public MovelControllerTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAll() {
        when(movelService.getAll()).thenReturn(Arrays.asList(new MovelResponseDTO(), new MovelResponseDTO()));
        List<MovelResponseDTO> result = movelController.getAll();
        verify(movelService, times(1)).getAll();
        assertEquals(2, result.size());
    }

    @Test
    public void testGetById() {
        Long id = 1L;
        MovelResponseDTO expectedMovel = new MovelResponseDTO();
        when(movelService.getById(id)).thenReturn(expectedMovel);
        MovelResponseDTO result = movelController.getById(id);
        verify(movelService, times(1)).getById(id);
        assertNotNull(result);
        assertEquals(expectedMovel, result);
    }

    @Test
    public void testCreate() {
        MovelRequestDTO movelRequest = new MovelRequestDTO();
        MovelResponseDTO expectedMovel = new MovelResponseDTO();
        when(movelService.create(movelRequest)).thenReturn(expectedMovel);
        MovelResponseDTO result = movelController.create(movelRequest);
        verify(movelService, times(1)).create(movelRequest);
        assertNotNull(result);
        assertEquals(expectedMovel, result);
    }

    @Test
    public void testUpdate() {
        Long id = 1L;
        MovelRequestDTO movelRequest = new MovelRequestDTO();
        MovelResponseDTO expectedMovel = new MovelResponseDTO();
        when(movelService.update(id, movelRequest)).thenReturn(expectedMovel);
        MovelResponseDTO result = movelController.update(id, movelRequest);
        verify(movelService, times(1)).update(id, movelRequest);
        assertNotNull(result);
        assertEquals(expectedMovel, result);
    }

    @Test
    public void testDeleteById() {
        Long id = 1L;
        movelController.deleteById(id);
        verify(movelService, times(1)).deleteById(id);
    }
}

