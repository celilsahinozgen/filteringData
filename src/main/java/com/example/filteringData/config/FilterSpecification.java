package com.example.filteringData.config;

import com.example.filteringData.model.Filter;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;
import java.util.function.Predicate;

public class FilterSpecification {



    public static Specification<Filter> createDateBetween(LocalDateTime createDate, LocalDateTime
            startCreateDate, LocalDateTime endCreateDate){
        return (root, query, builder) -> {
            Predicate predicate = builder.equal(root.get("createDate"), createDate);
            if (startCreateDate != null && endCreateDate != null) {
                predicate = builder.between(root.get("createDate"), startCreateDate, endCreateDate);
            } else if (startCreateDate != null) {
                predicate = builder.greaterThanOrEqualTo(root.get("createDate"), startCreateDate);
            } else if (endCreateDate != null) {
                predicate = builder.lessThanOrEqualTo(root.get("createDate"), endCreateDate);

            }
            return predicate;
                }  ;
        }

        public static Specification<Filter>  nameEquals(String name){
        return (root, query, builder) -> {
            return builder.equal(root.get("name"), name);
        };
    }

    public static Specification<Filter> ageGreaterThanOrEqualTo(Integer age){
        return (root, query, builder) -> {
            return builder.greaterThanOrEqualTo(root.get("age"),age);
        } ;
    }




    }

