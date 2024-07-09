package edu.pnu.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.pnu.domain.UserEntity;
import edu.pnu.dto.LoginDTO;
import edu.pnu.dto.LoginResponseDTO;
import edu.pnu.dto.ResponseDTO;
import edu.pnu.dto.SignUpDTO;
import edu.pnu.repository.UserRepository;
import edu.pnu.security.TokenProvider;

import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class AuthService {
    @Autowired 
    private UserRepository userRepository;
    @Autowired 
    private TokenProvider tokenProvider;

    @Autowired
    private  BCryptPasswordEncoder passwordEncoder;


    public  boolean userExists(String email) {
        Optional<UserEntity> userExist= userRepository.findByEmail(email);
        return userExist.isPresent();
    }

    public ResponseDTO<?> signUp(SignUpDTO dto) {

        String email = dto.getEmail();
        String password = dto.getPassword();
        String confirmPassword = dto.getConfirmPassword();

        // 존재하는 경우 : true / 존재하지 않는 경우 : false
        if(userExists(email)) {
                return ResponseDTO.setFailed("중복된 Email 입니다.");
        }

        if(!password.equals(confirmPassword)) {
            return ResponseDTO.setFailed("비밀번호가 일치하지 않습니다.");
        }

        // UserEntity 생성
        UserEntity userEntity = new UserEntity(dto);
        
     // 비밀번호 암호화
        String hashedPassword = passwordEncoder.encode(password);
        userEntity.setPassword(hashedPassword);

        try{
            userRepository.save(userEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDTO.setFailed("데이터베이스 연결에 실패하였습니다");
        }
        return ResponseDTO.setSuccess("회원 생성에 성공했습니다");
        }

        public ResponseDTO<LoginResponseDTO> login(LoginDTO dto) {
        String email = dto.getEmail();
        System.out.println("email은:"+email);
        String password = dto.getPassword();
        System.out.println("비번은:"+password);
        UserEntity userEntity;

        try{
            userEntity = userRepository.findByEmail(email).orElse(null);
            if(userEntity == null) {
                return ResponseDTO.setFailed("입력하신 이메딜로 등록된 계정이 없습니다.");
            }
            if(!passwordEncoder.matches(password, userEntity.getPassword())) {
                    return ResponseDTO.setFailed("비밀번호가 일치하지 않습니다.");
            }
            } catch(Exception e){
                e.printStackTrace();
                return ResponseDTO.setFailed("데이터 베이스 연결 실패.");
            }

        // UserRepository를 이용하여 DB에 Entity 저장 (데이터 적재)// Client에 비밀번호 제공 방지
        userEntity.setPassword("");

        int exprTime = 3600;     // 1h
        String token = tokenProvider.createJwt(email, exprTime);
        if(token == null) {
        	return ResponseDTO.setFailed("토큰 생성에 실패하였습니다.");
        }

        LoginResponseDTO loginResponseDto = new LoginResponseDTO(token, exprTime, userEntity);
        return ResponseDTO.setSuccessData(userEntity.getName()+ "님, 로그인에 성공하였습니다.", loginResponseDto);
    }
}
