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
@Table(name="senti_lg")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Senti_result_lg{

    @Id
    @Column(name="nid")
    private Integer nid;

    @Column(name= "large")
    private String large;

    @Column(name= "ns")
    private String NS;

    @Column(name= "ps")
    private String PS; //positive 평균

    @Column(name= "rate_avg")
    private Double rate_avg;

    @Column(name= "s_job_avg")
    private Double s_job_avg;

    @Column(name = "star_avg")
    private Double star_avg;
    @Column(name ="count")
    private Integer count;

}
