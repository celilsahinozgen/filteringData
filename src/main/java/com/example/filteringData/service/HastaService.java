package com.example.filteringData.service;

import com.example.filteringData.dto.HastaRequestDTO;
import com.example.filteringData.dto.HastaSaveDTO;
import com.example.filteringData.model.Hasta;
import com.example.filteringData.repository.HastaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HastaService {

    private final HastaRepository hastaRepository;
    private final ModelMapper modelMapper;

    public HastaService(HastaRepository hastaRepository, ModelMapper modelMapper) {
        this.hastaRepository = hastaRepository;
        this.modelMapper = modelMapper;
    }

    public List<HastaRequestDTO> findAllHasta() {
        List<Hasta> listHasta =  hastaRepository.findAll();
        List<HastaRequestDTO> listhastaDto = listHasta.stream().map(hasta -> modelMapper.map(hasta,HastaRequestDTO.class))
                .collect(Collectors.toList());
        return listhastaDto;
    }

    public HastaRequestDTO FindByHasta(Long id) {
        Optional<Hasta> optionalHasta = hastaRepository.findById(id);
        if (optionalHasta.isPresent()) {
            return modelMapper.map(optionalHasta.get(), HastaRequestDTO.class);
        }
        throw new RuntimeException("kullanıcı bulunamadı!!!");
    }


    public HastaSaveDTO save(HastaSaveDTO newHastaDto) {
        Hasta hasta = modelMapper.map(newHastaDto, Hasta.class);
        return modelMapper.map(hastaRepository.save(hasta),HastaSaveDTO.class);

    }
}