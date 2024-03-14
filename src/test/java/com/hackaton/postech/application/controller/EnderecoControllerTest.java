package com.hackaton.postech.application.controller;

import com.hackaton.postech.application.controller.EnderecoController;
import com.hackaton.postech.domain.dto.request.EnderecoRequestDTO;
import com.hackaton.postech.domain.dto.response.EnderecoResponseDTO;
import com.hackaton.postech.useCase.contract.IEnderecoService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class EnderecoControllerTest {

    @Mock
    private IEnderecoService enderecoService;

    @InjectMocks
    private EnderecoController enderecoController;

    public EnderecoControllerTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAll() {
        when(enderecoService.getAll()).thenReturn(Arrays.asList(new EnderecoResponseDTO(), new EnderecoResponseDTO()));

        List<EnderecoResponseDTO> result = enderecoController.getAll();

        verify(enderecoService, times(1)).getAll();

        assertEquals(2, result.size());
    }

    @Test
    public void testGetById() {
        Long id = 1L;
        EnderecoResponseDTO expectedEndereco = new EnderecoResponseDTO();
        when(enderecoService.getById(id)).thenReturn(expectedEndereco);

        EnderecoResponseDTO result = enderecoController.getById(id);

        verify(enderecoService, times(1)).getById(id);

        assertNotNull(result);
        assertEquals(expectedEndereco, result);
    }

    @Test
    public void testCreate() {
        EnderecoRequestDTO enderecoRequest = new EnderecoRequestDTO();
        EnderecoResponseDTO expectedEndereco = new EnderecoResponseDTO();
        when(enderecoService.create(enderecoRequest)).thenReturn(expectedEndereco);

        EnderecoResponseDTO result = enderecoController.create(enderecoRequest);

        verify(enderecoService, times(1)).create(enderecoRequest);

        assertNotNull(result);
        assertEquals(expectedEndereco, result);
    }

    @Test
    public void testUpdate() {
        Long id = 1L;
        EnderecoRequestDTO enderecoRequest = new EnderecoRequestDTO();
        EnderecoResponseDTO expectedEndereco = new EnderecoResponseDTO();
        when(enderecoService.update(id, enderecoRequest)).thenReturn(expectedEndereco);

        EnderecoResponseDTO result = enderecoController.update(id, enderecoRequest);

        verify(enderecoService, times(1)).update(id, enderecoRequest);

        assertNotNull(result);
        assertEquals(expectedEndereco, result);
    }

    @Test
    public void testDeleteById() {
        Long id = 1L;
        enderecoController.deleteById(id);

        verify(enderecoService, times(1)).deleteById(id);
    }
}

