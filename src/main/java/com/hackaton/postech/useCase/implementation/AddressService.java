package com.hackaton.postech.useCase.implementation;

import com.hackaton.postech.application.mapper.AddressMapper;
import com.hackaton.postech.domain.dto.request.AddressRequestDTO;
import com.hackaton.postech.domain.dto.response.AddressResponseDTO;
import com.hackaton.postech.domain.model.Address;
import com.hackaton.postech.domain.repository.AddressRepository;
import com.hackaton.postech.useCase.contract.IAddressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressService implements IAddressService {

    private static final String ADDRESS_NOT_FOUND = "Not found endereço ID: ";


    private final AddressRepository repository;

    private final AddressMapper addressMapper;


    @Override
    public List<AddressResponseDTO> getAll() {
//        return repository.findAll()
//                .stream()
//                .map(addressMapper::convertToAddressResponseDTO)
//                .toList();

        return null;
    }

    @Override
    public AddressResponseDTO getById(Long id) {
        return null;
//        return addressMapper.convertToAddressResponseDTO(findById(id));
    }

    @Override
    public AddressResponseDTO create(AddressRequestDTO addressRequest) {
//        return addressMapper.convertToAddressResponseDTO(repository
//                .save(addressMapper.convertToAddress(addressRequest)));
        return null;
    }

    @Override
    public AddressResponseDTO update(Long id, AddressRequestDTO addressRequest) {
//        getById(id);
//        return addressMapper.convertToAddressResponseDTO(repository
//                .save(addressMapper.convertToAddressWithId(addressRequest, id)));
        return null;
    }

    @Override
    public void deleteById(Long id) {
        getById(id);
        repository.deleteById(id);
    }

    private Address findById(Long id) {
//        return repository.findById(id)
//                .orElseThrow(() -> new NotFoundException(ADDRESS_NOT_FOUND + id));
        return null;
    }
}
