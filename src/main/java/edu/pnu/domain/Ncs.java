package edu.pnu.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//ncs_table 만들기
@Entity
@Table(name="ncs_table")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ncs {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ncsid;
	private String large;
	private String mid;
	private String small;
	private String ssmall;

}
