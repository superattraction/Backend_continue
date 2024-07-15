package edu.pnu.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name= "senti_ed")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Senti_ed {
    @Id
    @Column(name="eid")
    private Integer id;
    @Column(name="edu_institute")
    private String name;
    @Column(name="ps")
    private Integer ps;
    @Column(name = "ns")
    private Integer ns;
    @Column(name = "rate_avg")
    private Double rate_avg;
    @Column(name = "s_job_avg")
    private Double s_job_avg;
    @Column(name = "star_avg")
    private Double star_avg;
    @Column(name ="count")
    private Integer count;
}
