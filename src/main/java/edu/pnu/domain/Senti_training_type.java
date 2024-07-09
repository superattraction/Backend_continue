package edu.pnu.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "sentiment_avg_tt")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Senti_training_type {
    @Id
    @Column(name="tid")
    private Long id;

    @Column(name="training_type")
    private String trainingType;

    @Column(name = "ns")
    private String ns;

    @Column(name = "ps")
    private String ps;
}
