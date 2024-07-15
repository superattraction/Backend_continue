package edu.pnu.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//edu_list table 만들기
@Entity
@Table(name="maindata")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Edu_list {
	@Id
	@Column(name = "course_id")
	private Integer course_id;

	@Column(name="course_name")
	private String course_name;

	@Column(name="번호")
	private String phone;

	@Column(name="주소")
	private String address;

	@Column(name="address2")
	private String address2;

	@Column(name="교육비", columnDefinition="varchar(100)")
	private String fee;

    @Column(name = "ncs_num", columnDefinition="varchar(8)")  // 데이터베이스 컬럼 이름과 매핑
    private String ncsCode;

    @Column(name="ncs_ko")
	private String ncsKorean;

	@Column(name="starrating")
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
	@Column(name="goals",columnDefinition="text")
	private String goals;
	@OneToOne @JoinColumn(name = "course_id")
	private Summary_review summaryReview;
	@OneToOne @JoinColumn(name = "course_id")
	private Summary_content summaryContent;
	@Column(name="urls")
	private String urls;
	@Column(name="edu_institute")
	private String eduInstitute;


//	@PostLoad
//	public void postLoad() {
//		if(address!=null && !address.isEmpty()){
//            this.address2 = extractAddress(address);
//		}
//	}
//	private String extractAddress(String address) {
//		int firstSpaceIndex = address.indexOf(" ");
//		if (firstSpaceIndex != -1) {
//			int secondSpaceIndex = address.indexOf(" ", firstSpaceIndex + 1);
//			if (secondSpaceIndex != -1) {
//				return address.substring(0, secondSpaceIndex).trim();
//			} else {
//				return address.substring(0, firstSpaceIndex).trim(); // 두 번째 공백 문자가 없으면 첫 번째 공백 문자까지 자름
//			}
//		}
//		return address;
//	}

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
