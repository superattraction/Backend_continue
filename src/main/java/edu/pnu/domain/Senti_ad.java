package edu.pnu.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name= "senti_ad")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Senti_ad {
    @Id
    @Column(name="aid")
    private Integer id;

//    @Column(name)
}
