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
@Table(name="summary_content")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Summary_content {
    @Id
    @Column(name="course_id")
    private Integer course_id;
    @Column(name="course_name",columnDefinition = "TEXT")
    private String courseName;
    @Column(columnDefinition = "TEXT")
    private String summaryContent;

}
