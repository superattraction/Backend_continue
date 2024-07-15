package edu.pnu.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name ="senti_ad")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Senti_ad {
    @Id
    @Column(name = "aid")
    private Integer aid;
    @Column(name = "address")
    private String address;
    @Column(name ="ps")
    private Integer ps;
    @Column(name ="ns")
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
