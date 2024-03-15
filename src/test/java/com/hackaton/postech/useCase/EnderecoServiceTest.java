package com.hackaton.postech.useCase;

import com.hackaton.postech.application.mapper.EnderecoMapper;
import com.hackaton.postech.domain.dto.request.EnderecoRequestDTO;
import com.hackaton.postech.domain.dto.response.EnderecoResponseDTO;
import com.hackaton.postech.domain.model.Endereco;
import com.hackaton.postech.domain.repository.EnderecoRepository;
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
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EnderecoServiceTest {

    private static final String ENDERECO_NOT_FOUND = "Not found endereço ID: ";

    private final long enderecoId = 1L;
    private final long inexistenteId = 100;

    @InjectMocks
    private EnderecoService enderecoService;

    @Mock
    private EnderecoRepository repository;

    @Mock
    private EnderecoMapper enderecoMapper;

    private Endereco endereco;
    private EnderecoRequestDTO enderecoRequest;
    private EnderecoResponseDTO enderecoResponse;
    private List<Endereco> listaEnderecos;

    @BeforeEach
    void setUp() {
        listaEnderecos = umaListaDeEnderecos();
        endereco = umEndereco(enderecoId, "Rua Exemplo", 100, "Bairro Exemplo",
                "Cidade Exemplo", "Estado Exemplo");
        enderecoRequest = umEnderecoRequestDTO();
        enderecoResponse = umEnderecoResponseDTO(enderecoId);
    }

    @Test
    void getAll_deveRetornarListaDeEnderecos_quandoSolicitado() {
        when(repository.findAll()).thenReturn(listaEnderecos);
        when(enderecoMapper.convertToEnderecoResponseDTO(any(Endereco.class)))
                .thenReturn(enderecoResponse);

        List<EnderecoResponseDTO> resultado = enderecoService.getAll();

        assertThat(resultado).isNotNull().isNotEmpty().hasSize(listaEnderecos.size());
        verify(repository).findAll();
        listaEnderecos.forEach(endereco ->
                verify(enderecoMapper).convertToEnderecoResponseDTO(endereco));
    }

    @Test
    void getById_deveRetornarEnderecoResponseDTO_quandoEncontrado() {
        when(repository.findById(enderecoId)).thenReturn(Optional.of(endereco));
        when(enderecoMapper.convertToEnderecoResponseDTO(endereco)).thenReturn(enderecoResponse);

        EnderecoResponseDTO result = enderecoService.getById(enderecoId);

        assertThat(result).isEqualTo(enderecoResponse);
        verify(repository).findById(enderecoId);
    }

    @Test
    void getById_deveLancarException_quandoEnderecoNaoEncontrado() {
        when(repository.findById(inexistenteId)).thenReturn(Optional.empty());

        assertThatExceptionOfType(EntityNotFoundException.class)
                .isThrownBy(() -> enderecoService.getById(inexistenteId))
                .withMessageContaining(ENDERECO_NOT_FOUND + inexistenteId);

        verify(repository).findById(inexistenteId);
    }

    @Test
    void create_deveRetornarEnderecoResponseDTO_quandoSalvo() {
        when(repository.save(any(Endereco.class))).thenReturn(endereco);
        when(enderecoMapper.convertToEndereco(enderecoRequest)).thenReturn(endereco);
        when(enderecoMapper.convertToEnderecoResponseDTO(endereco)).thenReturn(enderecoResponse);

        var result = enderecoService.create(enderecoRequest);

        assertThat(result).isEqualTo(enderecoResponse);
        verify(repository).save(endereco);
        verify(enderecoMapper).convertToEndereco(enderecoRequest);
    }

    @Test
    void update_deveRetornarEnderecoResponseDTO_quandoAtualizado() {
        when(repository.findById(enderecoId)).thenReturn(Optional.of(endereco));
        when(enderecoMapper.convertToEnderecoWithId(enderecoRequest, enderecoId)).thenReturn(endereco);
        when(repository.save(any(Endereco.class))).thenReturn(endereco);
        when(enderecoMapper.convertToEnderecoResponseDTO(endereco)).thenReturn(enderecoResponse);

        var result = enderecoService.update(enderecoId, enderecoRequest);

        assertThat(result).isEqualTo(enderecoResponse);
        verify(repository).findById(enderecoId);
        verify(repository).save(endereco);
        verify(enderecoMapper).convertToEnderecoWithId(enderecoRequest, enderecoId);
    }

    @Test
    void deleteById_deveExecutarSemErro_quandoEnderecoExistente() {
        when(repository.findById(enderecoId)).thenReturn(Optional.of(endereco));
        doNothing().when(repository).deleteById(enderecoId);

        assertDoesNotThrow(() -> enderecoService.deleteById(enderecoId));

        verify(repository).findById(enderecoId);
        verify(repository).deleteById(enderecoId);
    }

    @Test
    void deleteById_deveLancarException_quandoEnderecoNaoEncontrado() {
        when(repository.findById(inexistenteId)).thenReturn(Optional.empty());

        assertThatExceptionOfType(EntityNotFoundException.class)
                .isThrownBy(() -> enderecoService.deleteById(inexistenteId))
                .withMessageContaining(ENDERECO_NOT_FOUND + inexistenteId);

        verify(repository).findById(inexistenteId);
        verify(repository, never()).deleteById(inexistenteId);
    }

    public List<Endereco> umaListaDeEnderecos() {
        return List.of(
                umEndereco(1L, "Rua A", 123, "Bairro A", "Cidade A", "Estado A"),
                umEndereco(2L, "Rua B", 456, "Bairro B", "Cidade B", "Estado B"),
                umEndereco(3L, "Rua C", 789, "Bairro C", "Cidade C", "Estado C")
        );
    }

    public Endereco umEndereco(Long id, String rua, Integer numero, String bairro, String cidade, String estado) {
        Endereco endereco = new Endereco();
        endereco.setId(id);
        endereco.setRua(rua);
        endereco.setNumero(numero);
        endereco.setBairro(bairro);
        endereco.setCidade(cidade);
        endereco.setEstado(estado);
        return endereco;
    }

    public EnderecoRequestDTO umEnderecoRequestDTO() {
        return EnderecoRequestDTO.builder()
                .rua("Rua Teste")
                .numero(101)
                .bairro("Bairro Teste")
                .cidade("Cidade Teste")
                .estado("Estado Teste")
                .build();
    }

    public static EnderecoResponseDTO umEnderecoResponseDTO(Long id) {
        return EnderecoResponseDTO.builder()
                .id(id)
                .rua("Rua Teste")
                .numero(101)
                .bairro("Bairro Teste")
                .cidade("Cidade Teste")
                .estado("Estado Teste")
                .build();
    }
}

