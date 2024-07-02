package edu.pnu.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//edu_list table 만들기
@Entity
@Table(name="final_data")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Edu_list {
	@Id 
	private Long Id;
	@OneToOne @JoinColumn(name = "Id", referencedColumnName = "course_id")
	private Senti_result sentiResult;
	@Column(name="course_name")
	private String title;
	@Column(name="번호")
	private String phone;
	@Column(name="주소")
	private String address;
	@Column(name="교육비", columnDefinition="varchar(500)")
	private String fee;
    @Column(name = "ncs_num", columnDefinition="varchar(1000)")  // 데이터베이스 컬럼 이름과 매핑
    private String ncsCode;
    @Column(name="ncs_ko")
	private String ncsKorean;
	private String starrating;
    @Column(name="certification_value")
	private String certification;
    @Column(name="average_age")
	private String averageAge;
    @Column(name="training_type")
    private String trainType;
    @Column(name="train_days")
    private String trainDay;
    @Column(name="train_time")
    private String trainTime;
	@OneToOne @JoinColumn(name = "Id", referencedColumnName = "course_id")
	private Summary_review summaryReview;
	@OneToOne @JoinColumn(name = "Id", referencedColumnName = "course_id")
	private Summary_content summaryContent;

//	@OneToOne @JoinColumn(name = "id", referencedColumnName = "course_id")
//	private Link link;

    
//    @Column(name="훈련목표", columnDefinition="varchar(5000)")
//    private String goals;
//    @Column(name="훈련대상 요건 선수학습",columnDefinition="varchar(5000)")
//    private String preTrain;
//    @Column(name="훈련대상 요건 직무경력", columnDefinition="varchar(5000)")
//    private String career;
//    @Column(name="훈련대상 요건 기취득자격", columnDefinition="varchar(5000)")
//    private String preCer;
//    @Column(name="훈련대상 요건 훈련과정의 강점", columnDefinition="varchar(5000)")
//    private String strength;
}
