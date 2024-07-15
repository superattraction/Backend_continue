package edu.pnu.domain;

import javax.persistence.Column;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="sentiment_avg")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Senti_result {
	@Id
    @Column(name="sid")
    private Long sid;
    private String ns; //negative 평균
    private String ps; //positive 평균

}
