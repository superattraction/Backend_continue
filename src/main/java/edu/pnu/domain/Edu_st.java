//package edu.pnu.domain;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//public class Edu_st {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @OneToOne(optional = true) // 널값허용
//    @JoinColumn(name = "labor_ad_id")
//    private Labor_ad labor_ad;
//
//    @OneToOne(optional = true) // 널값허용
//    @JoinColumn(name = "unemployed_ad_id")
//    private Unemployed_ad unemployed_ad;
//
//    @OneToOne(optional = true) // 널값허용
//    @JoinColumn(name = "owner_ad_id")
//    private Owner_ad owner_ad;
//}
