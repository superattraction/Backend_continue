package edu.pnu.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "labor_ad")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Labor_ad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name= "(훈련기관)시도")
    private String edu_institute_ad;

    @Column(name= "2024년01월")
    private Long l202401;
    @Column(name= "2024년02월")
    private Long l202402;
    @Column(name= "2024년03월")
    private Long l202403;
    @Column(name= "2024년04월")
    private Long l202404;
    @Column(name= "2024년05월")
    private Long l202405;

}
