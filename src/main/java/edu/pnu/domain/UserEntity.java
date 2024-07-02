package edu.pnu.domain;

import java.time.LocalDateTime;

import edu.pnu.dto.LoginResponseDTO;
import edu.pnu.dto.SignUpDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="user")			// 본인 테이블명과 맞춰주어야 함
public class UserEntity {
    @Id
    private String id;
    private String email;
    private String password;
    private String name;
    private String phoneNumber;
    private String userType;
    private String token;
    private LocalDateTime createdAt;
    private LocalDateTime editedAt;
    private LocalDateTime lastLoginAt;

    // 본인은 Email과 id를 동일하게 구성하기 위해 다음과 같이 작성하였다.
    public UserEntity(SignUpDTO dto) {
        this.id = dto.getId();
        this.email = dto.getEmail();
        this.password = dto.getPassword();
        this.name = dto.getName();
        this.phoneNumber = dto.getPhoneNumber();
        this.userType = dto.getUserType();
        this.token = "";
        this.createdAt = LocalDateTime.now();
        this.editedAt = LocalDateTime.now();
    }
    public UserEntity(LoginResponseDTO dto) {     
        this.lastLoginAt = LocalDateTime.now();
    }
    
}
