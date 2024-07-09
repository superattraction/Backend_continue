package edu.pnu.domain;

import jakarta.persistence.*;
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
	@Column(name = "ncsid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ncsid;

	@Column(name = "large")
	private String large;
	@Column(name = "mid")
	private String mid;
	@Column(name = "small")
	private String small;
	@Column(name = "ssmall")
	private String ssmall;

}
