package edu.pnu.domain;

import jakarta.persistence.*;
import lombok.*;



@Entity
@Table(name = "maindata")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Link {

    @Id
    @Column(name = "course_id")
    private int course_id;

    @Column(name="address2")
    private String edu_location;

    @Column(name = "edu_institute")
    private String educationName;

    @Column(name = "urls")
    private String detailPage;

//    @PostLoad
//    public void postLoad() {
//        if(edu_location!=null && !edu_location.isEmpty()){
//            this.edu_location = extractAddress(edu_location);
//        }
//    }
//    private String extractAddress(String address){
//        int index = address.indexOf("\n");
//        if(index != -1){
//            return address.substring(0,index).trim();
//        }
//        return address;
//    }
}
