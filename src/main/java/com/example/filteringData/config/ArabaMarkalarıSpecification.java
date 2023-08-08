package com.example.filteringData.config;

import com.example.filteringData.model.ArabaMarkalari;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.time.LocalDateTime;


public class ArabaMarkalarıSpecification {


    public static Specification<ArabaMarkalari> dogumTarihiBetween(LocalDateTime dogumTarihi, LocalDateTime
            startDogumTarihi, LocalDateTime endDogumTarihi){
        return (root, query, builder) -> {
            Predicate predicate = builder.equal(root.get("dogumTarihi"), dogumTarihi);
            if (startDogumTarihi != null && endDogumTarihi != null) {
                predicate = builder.between(root.get("dogumTarihi"), startDogumTarihi, endDogumTarihi);
            } else if (startDogumTarihi != null) {
                predicate = builder.greaterThanOrEqualTo(root.get("dogumTarihi"), startDogumTarihi);
            } else if (endDogumTarihi != null) {
                predicate = builder.lessThanOrEqualTo(root.get("dogumTarihi"), endDogumTarihi);

            }
            return predicate;
        }  ;
    }


//    public static Specification<ArabaMarkalari> dogumTarihiBetween(LocalDateTime startDogumTarihi, LocalDateTime endDogumTarihi) {
//        return (root, query, builder) -> {
//            return builder.between(root.get("dogumTarihi"), startDogumTarihi, endDogumTarihi);
//        };
//    }

                          //-------------------------------------------------------------

//    public static Specification<ArabaMarkalari> dogumTarihiBefore(LocalDateTime endDogumTarihi) {
//        return (root, query, builder) -> {
//            return builder.lessThan(root.get("dogumTarihi"), endDogumTarihi);
//        };
//    }


                         //-------------------------------------------------------------

//    public static Specification<ArabaMarkalari> dogumTarihiAfter(LocalDateTime startDogumTarihi) {
//        return (root, query, builder) -> {
//            return builder.greaterThan(root.get("dogumTarihi"), startDogumTarihi);
//        };
//    }


        public static Specification<ArabaMarkalari> dogumTarihiAfter(LocalDateTime startDogumTarihi) {
        return (root, query, builder) -> {
            return builder.greaterThanOrEqualTo(root.get("dogumTarihi"), startDogumTarihi);
        };
    }
    public static Specification<ArabaMarkalari> olumTarihiBetween(LocalDateTime olumTarihi, LocalDateTime
            startOlumTarihi, LocalDateTime endOlumTarihi){
        return (root, query, builder) -> {
            Predicate predicate = builder.equal(root.get("olumTarihi"), olumTarihi);
            if (startOlumTarihi != null && endOlumTarihi != null) {
                predicate = builder.between(root.get("olumTarihi"), startOlumTarihi, endOlumTarihi);
            } else if (startOlumTarihi != null) {
                predicate = builder.greaterThanOrEqualTo(root.get("olumTarihi"), startOlumTarihi);
            } else if (endOlumTarihi != null) {
                predicate = builder.lessThanOrEqualTo(root.get("olumTarihi"), endOlumTarihi);

            }
            return predicate;
        }  ;
    }

    public static Specification<ArabaMarkalari>  ulkeEquals(String ulke){
        return (root, query, builder) -> {
            return builder.equal(root.get("ulke"), ulke);
        };
    }
    public static Specification<ArabaMarkalari>  nameEquals(String name){
        return (root, query, builder) -> {
            return builder.equal(root.get("name"), name);
        };
    }
    public static Specification<ArabaMarkalari>  lastnameEquals(String lastname){
        return (root, query, builder) -> {
            return builder.equal(root.get("lastname"), lastname);
        };
    }


                        // Buradaki Yedek upper yada lower case yapmak için güzel yontemdir
//    public static Specification<ArabaMarkalari> ulkeEqualsIgnoreCase(String ulke) {
//        return (root, query, builder) -> {
//            return builder.equal(builder.upper(root.get("ulke")), ulke.toUpperCase());
//        };
//    }
//
//    public static Specification<ArabaMarkalari> ulkeEqualsIgnoreCase(String ulke) {
//        return (root, query, builder) -> {
//            return builder.equal(builder.lower(root.get("ulke")), ulke.toLowerCase());
//        };
//    }


                                // ********************
    // ******** ignor ederek de kullanılabilir aslında aşagıdaki örnek de
    /*
    public static void main(String[] args) {
    String ulke = "TÜRKİYE";

    Specification<ArabaMarkalari> specification = ulkeEqualsIgnoreCase(ulke);
    // Diğer sorgu işlemleri
}

public static Specification<ArabaMarkalari> ulkeEqualsIgnoreCase(String ulke) {
    return (root, query, builder) -> {
        return builder.equal(builder.lower(root.get("ulke")), ulke.toLowerCase());
    };
}
     */








}
