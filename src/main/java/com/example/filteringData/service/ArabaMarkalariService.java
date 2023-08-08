package com.example.filteringData.service;


import com.example.filteringData.config.ArabaMarkalarıSpecification;
import com.example.filteringData.dto.ArabaMarkalariDTO;
import com.example.filteringData.model.ArabaMarkalari;
import com.example.filteringData.repository.ArabaMarkalariRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArabaMarkalariService {


    private final ModelMapper modelMapper;
    private final ArabaMarkalariRepository arabaMarkalariRepository;


    public List<ArabaMarkalariDTO> filterArabaMarkalar(LocalDateTime dogumTarihi, LocalDateTime startDogumTarihi, LocalDateTime endDogumTarihi,
                                                       LocalDateTime olumTarihi, LocalDateTime startOlumTarihi, LocalDateTime endOlumTarihi,
                                                       String ulke, String name, String lastname) {

        try {
            Specification<ArabaMarkalari> arabaMarkalariSpecification = Specification.where(null);
                if (dogumTarihi != null || startDogumTarihi != null || endDogumTarihi != null){
                    arabaMarkalariSpecification = arabaMarkalariSpecification.and(ArabaMarkalarıSpecification.dogumTarihiBetween(dogumTarihi,startDogumTarihi,endDogumTarihi));
                }

//            if (startDogumTarihi != null && endDogumTarihi != null) {
//                arabaMarkalariSpecification = arabaMarkalariSpecification.and(ArabaMarkalarıSpecification.dogumTarihiBetween(startDogumTarihi, endDogumTarihi));
//            }


//            if (endDogumTarihi != null) {
//                arabaMarkalariSpecification = arabaMarkalariSpecification.and(ArabaMarkalarıSpecification.dogumTarihiBefore(endDogumTarihi));
//            }

                                    //-*-*-*-*-**-*----------------------------------------------

//            if (startDogumTarihi != null) {
//                arabaMarkalariSpecification = arabaMarkalariSpecification.and(ArabaMarkalarıSpecification.dogumTarihiAfter(startDogumTarihi));
//            }


            if (olumTarihi != null || startOlumTarihi != null || endOlumTarihi != null){
                arabaMarkalariSpecification = arabaMarkalariSpecification.and(ArabaMarkalarıSpecification.olumTarihiBetween(olumTarihi,startOlumTarihi,endOlumTarihi));
            }
                if (ulke != null){
                    arabaMarkalariSpecification = arabaMarkalariSpecification.and(ArabaMarkalarıSpecification.ulkeEquals(ulke));
                }
            if (name != null){
                arabaMarkalariSpecification = arabaMarkalariSpecification.and(ArabaMarkalarıSpecification.nameEquals(name));
            }
            if (lastname != null){
                arabaMarkalariSpecification = arabaMarkalariSpecification.and(ArabaMarkalarıSpecification.nameEquals(lastname));
            }

            List<ArabaMarkalari> arabaMarkalariList = arabaMarkalariRepository.findAll(arabaMarkalariSpecification);

            List<ArabaMarkalariDTO> arabaMarkalariDTOList = arabaMarkalariList.stream().map( arabaMarkalari -> modelMapper.map(arabaMarkalari, ArabaMarkalariDTO.class)).collect(Collectors.toList());
            return arabaMarkalariDTOList;
        }
        catch (Exception e) {
            throw  new RuntimeException("ArabaMarkalariService de bir hata oluştu  : " + e.getMessage(), e);
        }

    }
}
//Deprecated
//@PatchMapping
