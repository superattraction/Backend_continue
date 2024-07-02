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
@Table(name="sentiment_avg")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Senti_result {
	@Id
    @Column(name="course_id")
    private Long Sid;
    private String ns; //negative 평균
    private String ps; //positive 평균

}
