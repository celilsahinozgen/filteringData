package com.example.filteringData.service;

import com.example.filteringData.dto.DoktorRequestDTO;
import com.example.filteringData.dto.DoktorSaveDTO;
import com.example.filteringData.dto.DoktorUpdateDTO;
import com.example.filteringData.model.Doktor;
import com.example.filteringData.repository.DoktorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class DoktorService {

    private final DoktorRepository doktorRepository;
    private final ModelMapper modelMapper;

    public DoktorService(DoktorRepository doktorRepository, ModelMapper modelMapper) {
        this.doktorRepository = doktorRepository;
        this.modelMapper = modelMapper;
    }

    public List<DoktorRequestDTO> AllDoktor() {
        List<Doktor> listDoktor = doktorRepository.findAll();
        List<DoktorRequestDTO> ResponseDoktor = listDoktor.stream().map(doktor ->
                modelMapper.map(doktor, DoktorRequestDTO.class)).collect(Collectors.toList());
        return ResponseDoktor;
    }

    public DoktorRequestDTO findByDoktor(Long id) {
        Optional<Doktor> optionalDoktor = doktorRepository.findById(id);
        if (optionalDoktor.isPresent()){
            return modelMapper.map(optionalDoktor.get(), DoktorRequestDTO.class);
        }
        throw new RuntimeException("kullanıcıBulunamadı");
    }

    public DoktorSaveDTO saveDoktor(DoktorSaveDTO newDoktor) {
        Doktor doktor= modelMapper.map(newDoktor, Doktor.class);
        return modelMapper.map(doktorRepository.save(doktor),DoktorSaveDTO.class);
    }

    public DoktorUpdateDTO updateDoktor(Long id, DoktorUpdateDTO updateDoktor) {
        Optional<Doktor> optionalDoktor = doktorRepository.findById(id);
        if (optionalDoktor.isPresent()){
            optionalDoktor.get().setHastane(updateDoktor.getHastane());
            return modelMapper.map(doktorRepository.save(optionalDoktor.get()),DoktorUpdateDTO.class);
        }
        throw new RuntimeException("guncellenecek Kullanıcı Bulunamadı");
    }


    public Boolean deleteDoktor(Long id) {
        Optional<Doktor> optionalDoktor = doktorRepository.findById(id);
        if (optionalDoktor.isPresent()){
            doktorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

