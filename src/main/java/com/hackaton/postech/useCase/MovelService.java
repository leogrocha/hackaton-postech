package com.hackaton.postech.useCase;

import com.hackaton.postech.application.mapper.MovelMapper;
import com.hackaton.postech.domain.dto.request.MovelRequestDTO;
import com.hackaton.postech.domain.dto.response.MovelResponseDTO;
import com.hackaton.postech.domain.model.Movel;
import com.hackaton.postech.domain.repository.MovelRepository;
import com.hackaton.postech.useCase.contract.IMovelService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovelService implements IMovelService {

    private static final String MOVEL_NOT_FOUND = "Not found movel ID: ";

    private static MovelRepository repository;
    private final MovelMapper movelMapper;

    public static List<Movel> obterOuCriarMoveisPadrao(List<String> nomesMoveisPadrao) {
        List<Movel> moveisPadrao = new ArrayList<>();

        for (String nomeMovel : nomesMoveisPadrao) {
            Optional<Movel> optionalMovel = repository.findByDescricao(nomeMovel);
            Movel movel = optionalMovel.orElseGet(() -> {
                Movel novoMovel = new Movel(nomeMovel);
                return repository.save(novoMovel);
            });

            moveisPadrao.add(movel);
        }

        return moveisPadrao;
    }

    @Override
    public List<MovelResponseDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(movelMapper::convertToMovelResponseDTO)
                .toList();
    }

    @Override
    public MovelResponseDTO getById(Long id) {
        return movelMapper.convertToMovelResponseDTO(findById(id));
    }

    @Override
    public MovelResponseDTO create(MovelRequestDTO movelRequest) {
        return movelMapper.convertToMovelResponseDTO(repository
                .save(movelMapper.convertToMovel(movelRequest)));
    }

    @Override
    public MovelResponseDTO update(Long id, MovelRequestDTO movelRequest) {
        getById(id);
        return movelMapper.convertToMovelResponseDTO(repository
                .save(movelMapper.convertToMovelWithId(movelRequest, id)));
    }

    @Override
    public void deleteById(Long id) {
        getById(id);
        repository.deleteById(id);
    }

    private Movel findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(MOVEL_NOT_FOUND + id));
    }
}
