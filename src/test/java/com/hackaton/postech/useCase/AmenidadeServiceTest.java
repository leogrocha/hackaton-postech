package com.hackaton.postech.useCase;

import com.hackaton.postech.application.mapper.AmenidadeMapper;
import com.hackaton.postech.domain.dto.request.AmenidadeRequestDTO;
import com.hackaton.postech.domain.dto.response.AmenidadeResponseDTO;
import com.hackaton.postech.domain.model.Amenidade;
import com.hackaton.postech.domain.repository.AmenidadeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AmenidadeServiceTest {

    private static final String AMENIDADE_NOT_FOUND = "Not found Amenidade ID: ";

    private final long amenidadeId = 1L;
    private final long inexistenteId = 100;

    @InjectMocks
    private AmenidadeService amenidadeService;
    @Mock
    private AmenidadeRepository repository;
    @Mock
    private AmenidadeMapper amenidadeMapper;

    private Amenidade amenidade;
    private AmenidadeRequestDTO amenidadeRequest;
    private AmenidadeResponseDTO amenidadeResponse;
    private List<Amenidade> listaAmenidades;

    @BeforeEach
    void setUp() {
        listaAmenidades = umaListaAmenidades();
        amenidade = umaAmenidade(amenidadeId, "Piscina", 10L);
        amenidadeRequest = umAmenidadeRequestDTO("Piscina", 10L);
        amenidadeResponse = umAmenidadeResponseDTO(amenidadeId, "Piscina", 10L);
    }

    @Test
    void getAll_deveRetornarListaDeAmenidades_quandoSolicitado() {
        when(repository.findAll()).thenReturn(listaAmenidades);
        when(amenidadeMapper.convertToAmenidadeResponseDTO(any(Amenidade.class)))
                .thenReturn(amenidadeResponse);

        var resultado = amenidadeService.getAll();

        assertThat(resultado)
                .isInstanceOf(List.class)
                .isNotEmpty()
                .hasSize(listaAmenidades.size());

        verify(repository).findAll();
        listaAmenidades.forEach(amenidade ->
                verify(amenidadeMapper).convertToAmenidadeResponseDTO(amenidade));
    }

    @Test
    void getById_deveRetornarAmenidadeResponseDTO_quandoEncontrada() {
        when(repository.findById(amenidadeId))
                .thenReturn(Optional.of(amenidade));
        when(amenidadeMapper.convertToAmenidadeResponseDTO(amenidade))
                .thenReturn(amenidadeResponse);

        var resultado = amenidadeService.getById(amenidadeId);

        assertThat(resultado)
                .isInstanceOf(AmenidadeResponseDTO.class)
                .isNotNull();

        verify(repository).findById(amenidadeId);
    }

    @Test
    void getById_deveLancarException_quandoAmenidadeNaoEncontrada() {
        when(repository.findById(inexistenteId))
                .thenReturn(Optional.empty());

        assertThatExceptionOfType(EntityNotFoundException.class)
                .isThrownBy(() -> amenidadeService.getById(inexistenteId))
                .withMessage(AMENIDADE_NOT_FOUND + inexistenteId);

        verify(repository).findById(inexistenteId);
    }

    @Test
    void create_deveRetornarAmenidadeResponseDTO_quandoSalva() {
        when(repository.save(any(Amenidade.class)))
                .thenReturn(amenidade);
        when(amenidadeMapper.convertToAmenidade(amenidadeRequest))
                .thenReturn(amenidade);
        when(amenidadeMapper.convertToAmenidadeResponseDTO(amenidade))
                .thenReturn(amenidadeResponse);

        var resultado = amenidadeService.create(amenidadeRequest);

        assertThat(resultado)
                .isInstanceOf(AmenidadeResponseDTO.class)
                .isNotNull();

        verify(repository).save(amenidade);
        verify(amenidadeMapper).convertToAmenidade(amenidadeRequest);
    }

    @Test
    void update_deveRetornarAmenidadeResponseDTO_quandoAtualiza() {
        when(repository.findById(amenidadeId))
                .thenReturn(Optional.of(amenidade));
        when(repository.save(any(Amenidade.class)))
                .thenReturn(amenidade);
        when(amenidadeMapper.convertToAmenidadeWithId(amenidadeRequest, amenidadeId))
                .thenReturn(amenidade);
        when(amenidadeMapper.convertToAmenidadeResponseDTO(amenidade))
                .thenReturn(amenidadeResponse);

        var resultado = amenidadeService.update(amenidadeId, amenidadeRequest);

        assertThat(resultado)
                .isInstanceOf(AmenidadeResponseDTO.class)
                .isNotNull();

        verify(repository).findById(amenidadeId);
        verify(repository).save(amenidade);
        verify(amenidadeMapper).convertToAmenidadeWithId(amenidadeRequest, amenidadeId);
    }

    @Test
    void update_deveLancarException_quandoAmenidadeNaoEncontrada() {
        when(repository.findById(inexistenteId))
                .thenReturn(Optional.empty());

        assertThatExceptionOfType(EntityNotFoundException.class)
                .isThrownBy(() -> amenidadeService.update(inexistenteId, amenidadeRequest))
                .withMessage(AMENIDADE_NOT_FOUND + inexistenteId);

        verify(repository).findById(inexistenteId);
    }

    @Test
    void deleteById_deveDeletarAmenidade_quandoSolicitado() {
        when(repository.findById(amenidadeId))
                .thenReturn(Optional.of(amenidade));
        doNothing().when(repository)
                .deleteById(amenidadeId);

        assertThatCode(() -> amenidadeService.deleteById(amenidadeId))
                .doesNotThrowAnyException();

        verify(repository).findById(amenidadeId);
        verify(repository).deleteById(amenidadeId);
    }

    @Test
    void deleteById_deveLancarException_quandoAmenidadeNaoEncontrada() {
        when(repository.findById(inexistenteId))
                .thenReturn(Optional.empty());

        assertThatExceptionOfType(EntityNotFoundException.class)
                .isThrownBy(() -> amenidadeService.deleteById(inexistenteId))
                .withMessage(AMENIDADE_NOT_FOUND + inexistenteId);

        verify(repository).findById(inexistenteId);
    }

    public List<Amenidade> umaListaAmenidades() {
        return List.of(
                umaAmenidade(1L, "Piscina", 10L),
                umaAmenidade(2L, "Ginásio", 20L),
                umaAmenidade(3L, "Spa", 30L)
        );
    }

    public Amenidade umaAmenidade(Long id, String descricao, Long idLocalidade) {
        return Amenidade.builder()
                .id(id)
                .descricao(descricao)
                .idLocalidade(idLocalidade)
                .build();
    }

    public AmenidadeRequestDTO umAmenidadeRequestDTO(String descricao, Long idLocalidade) {
        return AmenidadeRequestDTO.builder()
                .descricao(descricao)
                .idLocalidade(idLocalidade)
                .build();
    }

    public AmenidadeResponseDTO umAmenidadeResponseDTO(Long id, String descricao, Long idLocalidade) {
        return AmenidadeResponseDTO.builder()
                .id(id)
                .descricao(descricao)
                .idLocalidade(idLocalidade)
                .build();
    }
}
