package com.hackaton.postech.useCase.implementation;


import com.hackaton.postech.domain.dto.request.MobileRequestDTO;
import com.hackaton.postech.domain.dto.response.MobileResponseDTO;
import com.hackaton.postech.domain.model.Mobile;
import com.hackaton.postech.domain.repository.MobileRepository;
import com.hackaton.postech.useCase.contract.IMobileService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MobileService implements IMobileService {

    private static final String MOBILE_NOT_FOUND = "Not found movel ID: ";


    private static MobileRepository repository;

//    @Autowired
//    public void setRepository(MobileRepository repository) {
//        MobileService.repository = repository;
//    }






    public static List<Mobile> obterOuCriarMoveisPadrao(List<String> nomesMoveisPadrao) {
        List<Mobile> moveisPadrao = new ArrayList<>();

        for (String nomeMovel : nomesMoveisPadrao) {
            Optional<Mobile> optionalMovel = repository.findByDescription(nomeMovel);
            Mobile movel = optionalMovel.orElseGet(() -> {
                Mobile novoMovel = new Mobile(nomeMovel);
                return repository.save(novoMovel);
            });

            moveisPadrao.add(movel);
        }

        return moveisPadrao;
    }

    @Override
    public List<MobileResponseDTO> getAll() {
        return null;
//        return repository.findAll()
//                .stream()
//                .map(mobileMapper::convertToMovelResponseDTO)
//                .toList();
    }

    @Override
    public MobileResponseDTO getById(Long id) {
        return null;
//        return mobileMapper.convertToMovelResponseDTO(findById(id));
    }

    @Override
    public MobileResponseDTO create(MobileRequestDTO movelRequest) {
        return null;
//        return mobileMapper.convertToMovelResponseDTO(repository
//                .save(mobileMapper.convertToMovel(movelRequest)));
    }

    @Override
    public MobileResponseDTO update(Long id, MobileRequestDTO movelRequest) {
        return null;
//        getById(id);
//        return mobileMapper.convertToMovelResponseDTO(repository
//                .save(mobileMapper.convertToMovelWithId(movelRequest, id)));
    }

    @Override
    public void deleteById(Long id) {
        getById(id);
        repository.deleteById(id);
    }

    private Mobile findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(MOBILE_NOT_FOUND + id));
    }
}
