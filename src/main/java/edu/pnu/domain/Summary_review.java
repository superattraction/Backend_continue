package edu.pnu.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//edu_list table 만들기
@Entity
@Table(name="summary_review")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Summary_review {
    @Id
    @Column(name="course_id")
    private Integer course_id;
    @Column(name ="course_name")
    private String course_Name;
    @Column(name="summary_review",columnDefinition = "TEXT")
    private String summary_review;

    @Column(name= "edu_institute")
    private String edu_institute;

    @Column(name= "training_type")
    private String training_type;
    @Column(name = "address")
    private String address;

    @Column(name ="ps")
    private Integer ps;

    @Column(name = "ns")
    private Integer ns;

    @Column(name = "ncs_num")
    private String ncs_num;

}
