package com.hackaton.postech.useCase;

import com.hackaton.postech.application.mapper.EnderecoMapper;
import com.hackaton.postech.application.mapper.LocalidadeMapper;
import com.hackaton.postech.domain.dto.request.LocalidadeRequestDTO;
import com.hackaton.postech.domain.dto.response.EnderecoResponseDTO;
import com.hackaton.postech.domain.dto.response.LocalidadeResponseDTO;
import com.hackaton.postech.domain.model.Endereco;
import com.hackaton.postech.domain.model.Localidade;
import com.hackaton.postech.domain.repository.LocalidadeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;
import java.util.Optional;

import static com.hackaton.postech.useCase.EnderecoServiceTest.umEnderecoResponseDTO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LocalidadeServiceTest {

    private static final String LOCALIDADE_NOT_FOUND = "Not found localidade ID: ";
    private final long localidadeId = 1L;
    private final long inexistenteId = 100L;

    @InjectMocks
    private LocalidadeService localidadeService;
    @Mock
    private LocalidadeRepository localidadeRepository;
    @Mock
    private LocalidadeMapper localidadeMapper;
    @Mock
    private EnderecoService enderecoService;
    @Mock
    private EnderecoMapper enderecoMapper;

    private Localidade localidade;
    private LocalidadeRequestDTO localidadeRequestDTO;
    private LocalidadeResponseDTO localidadeResponseDTO;
    private List<Localidade> listaLocalidades;

    @BeforeEach
    void setUp() {
        listaLocalidades = umaListaDeLocalidades();
        localidade = umaLocalidade(localidadeId);
        localidadeRequestDTO = umLocalidadeRequestDTO();
        localidadeResponseDTO = umLocalidadeResponseDTO();
    }

    @Test
    void getAll_deveRetornarListaDeLocalidades_quandoSolicitado() {
        when(localidadeRepository.findAll()).thenReturn(listaLocalidades);
        when(localidadeMapper.convertToLocalidadeResponseDTO(any(Localidade.class)))
                .thenReturn(localidadeResponseDTO);

        var resultado = localidadeService.getAll();

        assertThat(resultado)
                .isInstanceOf(List.class)
                .isNotEmpty()
                .hasSize(listaLocalidades.size());

        verify(localidadeRepository).findAll();
        listaLocalidades.forEach(localidade ->
                verify(localidadeMapper).convertToLocalidadeResponseDTO(localidade));
    }

    @Test
    void getById_deveRetornarLocalidadeResponseDTO_quandoEncontrado() {
        when(localidadeRepository.findById(localidadeId))
                .thenReturn(Optional.of(localidade));
        when(localidadeMapper.convertToLocalidadeResponseDTO(localidade))
                .thenReturn(localidadeResponseDTO);

        var resultado = localidadeService.getById(localidadeId);

        assertThat(resultado)
                .isInstanceOf(LocalidadeResponseDTO.class)
                .isEqualTo(localidadeResponseDTO);

        verify(localidadeRepository).findById(localidadeId);
    }

    @Test
    void create_deveRetornarLocalidadeResponseDTO_quandoCriadoComSucesso() {
        ArgumentCaptor<Localidade> localidadeCaptor = ArgumentCaptor.forClass(Localidade.class);
        when(localidadeRepository.save(any(Localidade.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));
        doReturn(localidadeResponseDTO).when(localidadeMapper).convertToLocalidadeResponseDTO(localidadeCaptor.capture());

        localidadeService.create(localidadeRequestDTO);

        verify(localidadeMapper).convertToLocalidadeResponseDTO(localidadeCaptor.getValue());
    }

    @Test
    void create_deveLancarException_quandoEnderecoJaExiste() {
        when(localidadeRepository.save(any(Localidade.class)))
                .thenThrow(DataIntegrityViolationException.class);

        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> localidadeService.create(localidadeRequestDTO))
                .withMessageContaining("Localidade already exists at this address");

        verify(localidadeRepository, never()).save(localidade);
    }

    @Test
    void update_deveRetornarLocalidadeAtualizada_quandoSucesso() {
        when(localidadeRepository.findById(localidadeId)).thenReturn(Optional.of(localidade));
        when(enderecoService.getById(localidadeRequestDTO.getIdEndereco())).thenReturn(EnderecoResponseDTO.of(new Endereco()));
        when(localidadeMapper.convertToLocalidadeResponseDTO(localidade)).thenReturn(localidadeResponseDTO);
        when(localidadeMapper.convertToLocalidade(any(LocalidadeResponseDTO.class))).thenReturn(localidade);
        when(localidadeRepository.save(any(Localidade.class))).thenReturn(localidade);

        var resultado = localidadeService.update(localidadeId, localidadeRequestDTO);

        assertThat(resultado).isNotNull().isEqualTo(localidadeResponseDTO);
        verify(localidadeRepository).save(localidade);
        verify(localidadeMapper).convertToLocalidadeResponseDTO(localidade);
    }

    @Test
    void update_deveLancarException_quandoLocalidadeNaoEncontrada() {
        when(localidadeRepository.findById(inexistenteId))
                .thenReturn(Optional.empty());

        assertThatExceptionOfType(EntityNotFoundException.class)
                .isThrownBy(() -> localidadeService.update(inexistenteId, localidadeRequestDTO))
                .withMessageContaining(LOCALIDADE_NOT_FOUND + inexistenteId);

        verify(localidadeRepository, never()).save(any(Localidade.class));
    }

    @Test
    void deleteById_deveDeletarLocalidade_quandoSucesso() {
        when(localidadeRepository.findById(localidadeId)).thenReturn(Optional.of(localidade));
        doNothing().when(localidadeRepository).deleteById(localidadeId);

        localidadeService.deleteById(localidadeId);

        verify(localidadeRepository).deleteById(localidadeId);
    }

    @Test
    void deleteById_deveLancarException_quandoLocalidadeNaoEncontrada() {
        when(localidadeRepository.findById(inexistenteId)).thenReturn(Optional.empty());

        assertThatExceptionOfType(EntityNotFoundException.class)
                .isThrownBy(() -> localidadeService.deleteById(inexistenteId))
                .withMessageContaining(LOCALIDADE_NOT_FOUND + inexistenteId);

        verify(localidadeRepository, never()).deleteById(inexistenteId);
    }

    @Test
    void getById_deveLancarException_quandoLocalidadeNaoEncontrado() {
        when(localidadeRepository.findById(inexistenteId))
                .thenReturn(Optional.empty());

        assertThatExceptionOfType(EntityNotFoundException.class)
                .isThrownBy(() -> localidadeService.getById(inexistenteId))
                .withMessageContaining(LOCALIDADE_NOT_FOUND + inexistenteId);

        verify(localidadeRepository).findById(inexistenteId);
    }

    private List<Localidade> umaListaDeLocalidades() {
        return List.of(umaLocalidade(1L), umaLocalidade(2L), umaLocalidade(3L));
    }

    private Localidade umaLocalidade(Long id) {
        var localidade = new Localidade();
        localidade.setId(id);
        return localidade;
    }

    private LocalidadeRequestDTO umLocalidadeRequestDTO() {
        return new LocalidadeRequestDTO();
    }

    private LocalidadeResponseDTO umLocalidadeResponseDTO() {
        var responseDTO = new LocalidadeResponseDTO();
        responseDTO.setId(1L);
        return responseDTO;
    }
}
