package com.hackaton.postech.useCase;

import com.hackaton.postech.application.mapper.PredioMapper;
import com.hackaton.postech.domain.dto.request.PredioRequestDTO;
import com.hackaton.postech.domain.dto.response.PredioResponseDTO;
import com.hackaton.postech.domain.dto.response.QuartoResponseDTO;
import com.hackaton.postech.domain.model.Predio;
import com.hackaton.postech.domain.model.Quarto;
import com.hackaton.postech.domain.repository.PredioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PredioServiceTest {

    private static final String PREDIO_NOT_FOUND = "Not found Predio ID: ";

    private final long predioId = 1L;
    private final long inexistenteId = 100;

    @InjectMocks
    private PredioService predioService;
    @Mock
    private PredioRepository repository;
    @Mock
    private PredioMapper predioMapper;

    private Predio predio;
    private PredioRequestDTO predioRequest;
    private PredioResponseDTO predioResponse;
    private List<Predio> listaPredios;

    @BeforeEach
    void setUp() {
        listaPredios = umaListaPredios();
        predio = umPredio(predioId, "Edificio Principal", 10L, new ArrayList<>());
        predioRequest = umPredioRequestDTO("Edificio Principal", 10L);
        predioResponse = umPredioResponseDTO(predioId, "Edificio Principal", 10L, Collections.emptyList());
    }


    @Test
    void getAll_deveRetornarListaDePredios_quandoSolicitado() {
        when(repository.findAll()).thenReturn(listaPredios);
        when(predioMapper.convertToPredioResponseDTO(any(Predio.class)))
                .thenReturn(predioResponse);

        var resultado = predioService.getAll();

        assertThat(resultado)
                .isNotNull()
                .isNotEmpty()
                .hasSize(listaPredios.size());

        verify(repository).findAll();
        listaPredios.forEach(predio ->
                verify(predioMapper).convertToPredioResponseDTO(predio));
    }

    @Test
    void getById_deveRetornarPredioResponseDTO_quandoEncontrado() {
        when(repository.findById(predioId)).thenReturn(Optional.of(predio));
        when(predioMapper.convertToPredioResponseDTO(predio)).thenReturn(predioResponse);

        var result = predioService.getById(predioId);

        assertThat(result).isNotNull().isEqualTo(predioResponse);
        verify(repository).findById(predioId);
    }

    @Test
    void getById_deveLancarException_quandoPredioNaoEncontrado() {
        when(repository.findById(inexistenteId)).thenReturn(Optional.empty());

        assertThatExceptionOfType(EntityNotFoundException.class)
                .isThrownBy(() -> predioService.getById(inexistenteId))
                .withMessageContaining(PREDIO_NOT_FOUND + inexistenteId);

        verify(repository).findById(inexistenteId);
    }

    @Test
    void create_deveRetornarPredioResponseDTO_quandoSalvo() {
        when(predioMapper.convertToPredio(predioRequest)).thenReturn(predio);
        when(repository.save(any(Predio.class))).thenReturn(predio);
        when(predioMapper.convertToPredioResponseDTO(predio)).thenReturn(predioResponse);

        var result = predioService.create(predioRequest);

        assertThat(result).isEqualTo(predioResponse);
        verify(repository).save(predio);
        verify(predioMapper).convertToPredio(predioRequest);
    }

    @Test
    void update_deveRetornarPredioResponseDTO_quandoAtualizado() {
        when(repository.findById(predioId)).thenReturn(Optional.of(predio));
        when(predioMapper.convertToPredioWithId(predioRequest, predioId)).thenReturn(predio);
        when(repository.save(predio)).thenReturn(predio);
        when(predioMapper.convertToPredioResponseDTO(predio)).thenReturn(predioResponse);

        var result = predioService.update(predioId, predioRequest);

        assertThat(result).isEqualTo(predioResponse);
        verify(repository).findById(predioId);
        verify(repository).save(predio);
        verify(predioMapper).convertToPredioWithId(predioRequest, predioId);
    }

    @Test
    void deleteById_deveNaoLancarExcecao_quandoSucesso() {
        when(repository.findById(predioId)).thenReturn(Optional.of(predio));
        doNothing().when(repository).deleteById(predioId);

        assertDoesNotThrow(() -> predioService.deleteById(predioId));

        verify(repository).findById(predioId);
        verify(repository).deleteById(predioId);
    }

    @Test
    void deleteById_deveLancarException_quandoPredioNaoEncontrado() {
        when(repository.findById(inexistenteId)).thenThrow(new EntityNotFoundException(PREDIO_NOT_FOUND + inexistenteId));

        assertThatExceptionOfType(EntityNotFoundException.class)
                .isThrownBy(() -> predioService.deleteById(inexistenteId))
                .withMessageContaining(PREDIO_NOT_FOUND + inexistenteId);

        verify(repository).findById(inexistenteId);
        verify(repository, never()).deleteById(inexistenteId);
    }

    private List<Predio> umaListaPredios() {
        return List.of(
                umPredio(1L, "Predio A", 10L, new ArrayList<>()),
                umPredio(2L, "Predio B", 20L, new ArrayList<>()),
                umPredio(3L, "Predio C", 30L, new ArrayList<>())
        );
    }

    private Predio umPredio(Long id, String nome, Long idLocalidade, List<Quarto> quartos) {
        Predio predio = new Predio();
        predio.setId(id);
        predio.setNome(nome);
        predio.setIdLocalidade(idLocalidade);
        predio.setQuartos(quartos);
        return predio;
    }

    private PredioRequestDTO umPredioRequestDTO(String nome, Long idLocalidade) {
        return PredioRequestDTO.builder()
                .nome(nome)
                .idLocalidade(idLocalidade)
                .build();
    }

    private PredioResponseDTO umPredioResponseDTO(Long id, String nome, Long idLocalidade,
                                                  List<QuartoResponseDTO> quartosResponse) {
        return PredioResponseDTO.builder()
                .id(id)
                .nome(nome)
                .idLocalidade(idLocalidade)
                .quartos(quartosResponse)
                .build();
    }
}

