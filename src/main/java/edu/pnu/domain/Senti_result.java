package edu.pnu.domain;

import javax.persistence.Column;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="sentiment_result")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Senti_result {
	@Id
    @Column(name="course_id")
    private Integer course_id;

    @Column(name="course_name")
    private String course_name;

    @Column(name ="ncs_num2",columnDefinition = "varchar(2)")
    private String ncs_num2;

    @Column(name = "training_type")
    private String training_type;

    @Column(name = "edu_institute")
    private String edu_institute;

    @Column(name = "ns")
    private String ns; //negative 평균
    @Column(name = "ps")
    private String ps; //positive 평균

}
