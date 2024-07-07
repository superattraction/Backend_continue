package edu.pnu.domain;

import javax.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="sentiment_avg_lg")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Senti_result_lg{
    @Id
    @Column(name="id")
    private Long id;

    @Column(name="large")
    private String large;

    @Column(name = "Ns")
    private String NS;

    @Column(name = "PS")//negative 평균
    private String PS; //positive 평균

}
