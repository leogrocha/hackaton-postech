package com.hackaton.postech.useCase;

import com.hackaton.postech.application.mapper.ClienteMapper;
import com.hackaton.postech.domain.dto.request.ClienteRequestDTO;
import com.hackaton.postech.domain.dto.response.ClienteResponseDTO;
import com.hackaton.postech.domain.model.Cliente;
import com.hackaton.postech.domain.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {

    private static final String CLIENTE_NOT_FOUND = "Cliente não encontrado, id: ";

    private final long clienteId = 1L;
    private final long inexistenteId = 100;

    @InjectMocks
    private ClienteService clienteService;
    @Mock
    private ClienteRepository repository;
    @Mock
    private ClienteMapper clienteMapper;

    private Cliente cliente;
    private ClienteRequestDTO clienteRequestDTO;
    private ClienteResponseDTO clienteResponseDTO;
    private List<Cliente> listaClientes;

    @BeforeEach
    void setUp() {
        listaClientes = umaListaClientes();
        cliente = umCliente(clienteId);
        clienteRequestDTO = umClienteRequestDTO();
        clienteResponseDTO = umClienteResponseDTO();
    }

    @Test
    void getAll_deveRetornarListaDeClientes_quandoSolicitado() {
        when(repository.findAll()).thenReturn(listaClientes);
        when(clienteMapper.convertToClienteResponse(any(Cliente.class)))
                .thenReturn(clienteResponseDTO);

        var resultado = clienteService.getAll();

        assertThat(resultado)
                .isInstanceOf(List.class)
                .isNotEmpty()
                .hasSize(listaClientes.size());

        verify(repository).findAll();
        listaClientes.forEach(cliente ->
                verify(clienteMapper).convertToClienteResponse(cliente));
    }

    @Test
    void getById_deveRetornarClienteResponseDTO_quandoEncontrado() {
        when(repository.findById(clienteId))
                .thenReturn(Optional.of(cliente));
        when(clienteMapper.convertToClienteResponse(cliente))
                .thenReturn(clienteResponseDTO);

        var resultado = clienteService.getById(clienteId);

        assertThat(resultado)
                .isInstanceOf(ClienteResponseDTO.class)
                .isEqualTo(clienteResponseDTO);

        verify(repository).findById(clienteId);
    }

    @Test
    void getById_deveLancarException_quandoClienteNaoEncontrado() {
        when(repository.findById(inexistenteId))
                .thenReturn(Optional.empty());

        assertThatExceptionOfType(EntityNotFoundException.class)
                .isThrownBy(() -> clienteService.getById(inexistenteId))
                .withMessageContaining("Cliente não encontrado na base de dados.");

        verify(repository).findById(inexistenteId);
    }

    @Test
    void create_deveRetornarClienteResponseDTO_quandoSalvo() {
        when(clienteMapper.convertToCliente(clienteRequestDTO)).thenReturn(cliente);
        when(repository.save(any(Cliente.class))).thenReturn(cliente);
        when(clienteMapper.convertToClienteResponse(cliente)).thenReturn(clienteResponseDTO);

        var resultado = clienteService.create(clienteRequestDTO);

        assertThat(resultado)
                .isNotNull()
                .isEqualTo(clienteResponseDTO);
        verify(repository).save(cliente);
        verify(clienteMapper).convertToCliente(clienteRequestDTO);
        verify(clienteMapper).convertToClienteResponse(cliente);
    }

    @Test
    void update_deveRetornarClienteResponseDTO_quandoAtualizado() {
        when(repository.getReferenceById(clienteId)).thenReturn(cliente);
        when(clienteMapper.convertToCliente(clienteRequestDTO)).thenReturn(cliente);
        when(repository.save(any(Cliente.class))).thenReturn(cliente);
        when(clienteMapper.convertToClienteResponse(cliente)).thenReturn(clienteResponseDTO);

        var resultado = clienteService.update(clienteId, clienteRequestDTO);

        assertThat(resultado)
                .isNotNull()
                .isEqualTo(clienteResponseDTO);
        verify(repository).getReferenceById(clienteId);
        verify(repository).save(cliente);
        verify(clienteMapper).convertToCliente(clienteRequestDTO);
        verify(clienteMapper).convertToClienteResponse(cliente);
    }

    @Test
    void update_deveLancarException_quandoClienteNaoEncontrado() {
        when(repository.getReferenceById(inexistenteId)).thenThrow(EntityNotFoundException.class);

        assertThatExceptionOfType(EntityNotFoundException.class)
                .isThrownBy(() -> clienteService.update(inexistenteId, clienteRequestDTO))
                .withMessageContaining("Cliente não encontrado, id: " + inexistenteId);

        verify(repository).getReferenceById(inexistenteId);
        verify(repository, never()).save(any(Cliente.class));
    }

    @Test
    void deleteById_deveDeletarCliente_quandoSolicitado() {
        when(repository.findById(clienteId)).thenReturn(Optional.of(cliente));
        doNothing().when(repository).deleteById(clienteId);

        clienteService.deleteById(clienteId);

        verify(repository).findById(clienteId);
        verify(repository).deleteById(clienteId);
    }

    @Test
    void deleteById_deveLancarException_quandoClienteNaoEncontrado() {
        when(repository.findById(inexistenteId)).thenThrow(EntityNotFoundException.class);

        assertThatExceptionOfType(EntityNotFoundException.class)
                .isThrownBy(() -> clienteService.deleteById(inexistenteId))
                .withMessageContaining("Cliente não encontrado, id: " + inexistenteId);

        verify(repository).findById(inexistenteId);
        verify(repository, never()).deleteById(inexistenteId);
    }

    private List<Cliente> umaListaClientes() {
        return List.of(umCliente(1L), umCliente(2L), umCliente(3L));
    }

    private Cliente umCliente(Long id) {
        Cliente cliente = new Cliente();
        cliente.setId(id);
        return cliente;
    }

    private ClienteRequestDTO umClienteRequestDTO() {
        return new ClienteRequestDTO();
    }

    private ClienteResponseDTO umClienteResponseDTO() {
        ClienteResponseDTO clienteResponseDTO = new ClienteResponseDTO();
        clienteResponseDTO.setId(1L);
        return clienteResponseDTO;
    }
}
