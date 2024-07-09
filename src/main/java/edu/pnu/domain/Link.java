package edu.pnu.domain;

import jakarta.persistence.*;
import lombok.*;



@Entity
@Table(name = "link_idx")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Link {

    @Id
    @Column(name = "course_id")
    private Long course_id;

    @Column(name="교육기관위치")
    private String edu_location;

    @Column(name = "교육명")
    private String educationName;

    @Column(name = "상세페이지")
    private String detailPage;

    @PostLoad
    public void postLoad() {
        if(edu_location!=null && !edu_location.isEmpty()){
            this.edu_location = extractAddress(edu_location);
        }
    }
    private String extractAddress(String address){
        int index = address.indexOf("\n");
        if(index != -1){
            return address.substring(0,index).trim();
        }
        return address;
    }
}
