package com.hackaton.postech.application.controller;

import com.hackaton.postech.domain.dto.request.LocalidadeRequestDTO;
import com.hackaton.postech.domain.dto.response.LocalidadeResponseDTO;
import com.hackaton.postech.useCase.contract.ILocalidadeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class LocalidadeControllerTest {

    @Mock
    private ILocalidadeService localidadeService;

    @InjectMocks
    private LocalidadeController localidadeController;

    public LocalidadeControllerTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAll() {
        when(localidadeService.getAll()).thenReturn(Arrays.asList(new LocalidadeResponseDTO(), new LocalidadeResponseDTO()));
        List<LocalidadeResponseDTO> result = localidadeController.getAll();
        verify(localidadeService, times(1)).getAll();
        assertEquals(2, result.size());
    }

    @Test
    public void testGetById() {
        Long id = 1L;
        LocalidadeResponseDTO expectedLocalidade = new LocalidadeResponseDTO();
        when(localidadeService.getById(id)).thenReturn(expectedLocalidade);
        LocalidadeResponseDTO result = localidadeController.getById(id);
        verify(localidadeService, times(1)).getById(id);
        assertNotNull(result);
        assertEquals(expectedLocalidade, result);
    }

    @Test
    public void testCreate() {
        LocalidadeRequestDTO localidadeRequest = new LocalidadeRequestDTO();
        LocalidadeResponseDTO expectedLocalidade = new LocalidadeResponseDTO();
        when(localidadeService.create(localidadeRequest)).thenReturn(expectedLocalidade);
        LocalidadeResponseDTO result = localidadeController.create(localidadeRequest);
        verify(localidadeService, times(1)).create(localidadeRequest);
        assertNotNull(result);
        assertEquals(expectedLocalidade, result);
    }

    @Test
    public void testUpdate() {
        Long id = 1L;
        LocalidadeRequestDTO localidadeRequest = new LocalidadeRequestDTO();
        LocalidadeResponseDTO expectedLocalidade = new LocalidadeResponseDTO();
        when(localidadeService.update(id, localidadeRequest)).thenReturn(expectedLocalidade);
        LocalidadeResponseDTO result = localidadeController.update(id, localidadeRequest);
        verify(localidadeService, times(1)).update(id, localidadeRequest);
        assertNotNull(result);
        assertEquals(expectedLocalidade, result);
    }

    @Test
    public void testDeleteById() {
        Long id = 1L;
        localidadeController.deleteById(id);
        verify(localidadeService, times(1)).deleteById(id);
    }
}
