package com.example.filteringData.service;

import com.example.filteringData.dto.HastaneRequestDTO;
import com.example.filteringData.dto.HastaneSaveDTO;
import com.example.filteringData.model.Hastane;
import com.example.filteringData.repository.HastaneRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class HastaneService {

    private final HastaneRepository hastaneRepository;
    private final ModelMapper modelMapper;


    public HastaneService(HastaneRepository hastaneRepository, ModelMapper modelMapper) {
        this.hastaneRepository = hastaneRepository;
        this.modelMapper = modelMapper;
    }

    public List<HastaneRequestDTO> findAllHastane() {

        List<Hastane> listHastane = hastaneRepository.findAll();
        List<HastaneRequestDTO> listRequestDto = listHastane.stream()
                .map(hastane -> modelMapper.map(hastane, HastaneRequestDTO.class)).collect(Collectors.toList());
        return listRequestDto;
    }

    public HastaneSaveDTO saveHastane(HastaneSaveDTO newHastane) {
        Hastane hastane = modelMapper.map(newHastane, Hastane.class);
        return modelMapper.map(hastaneRepository.save(hastane), HastaneSaveDTO.class);
    }

}

