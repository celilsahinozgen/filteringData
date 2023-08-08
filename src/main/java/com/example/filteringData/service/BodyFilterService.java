//package com.example.filteringData.service;
//
//import com.example.filteringData.dto.FilterRequestDTO;
//import com.example.filteringData.model.Filter;
//import com.example.filteringData.repository.FilterRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.jpa.domain.Specification;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class BodyFilterService {
//
//    private final FilterRepository filterRepository;
//
//
//    public List<FilterRequestDTO> filterArabaMarkalar(Long tckNo, String name, String name1, Integer age, String il, String ilce, String lastname, LocalDateTime createDate, LocalDateTime updateDate)
//    {
//        try {
//
//            Specification<Filter> filterSpecification = Specification.where(null);
//
//            if (createDate != null || startcreateDate != null || endcreateDate != null){
//                filterSpecification = filterSpecification.and(FilterSpecification.createDateBetween(createDate,startcreateDate,endcreateDate));
//            }
//
//            if (name != null){
//                filterSpecification = filterSpecification.and(FilterSpecification.nameEquals(name));
//            }
//
//
//
//            Pageable pageable = PageRequest.of(page,size);
//            Page<Filter> filterPage = filterRepository.findAll( filterSpecification, pageable);
//
//            List<FilterRequestDTO> filterRequestDTOS  = filterPage.stream().map(filter -> modelMapper.map(filter, FilterRequestDTO.class)).collect(Collectors.toList());
//            return filterRequestDTOS;
//
//        }catch (Exception e) {
//            throw  new RuntimeException("Serviste bir hata oluştu  : " + e.getMessage(), e);
//        }
//    }
//}
