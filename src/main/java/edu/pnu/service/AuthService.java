package edu.pnu.service;

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
@Service
public class AuthService {
    @Autowired 
    UserRepository userRepository;
    @Autowired 
    TokenProvider tokenProvider;
    public ResponseDTO<?> signUp(SignUpDTO dto) {
        String email = dto.getEmail();
        String password = dto.getPassword();
        String confirmPassword = dto.getConfirmPassword();

        // email(id) 중복 확인
        try {
            // 존재하는 경우 : true / 존재하지 않는 경우 : false
            if(userRepository.existsById(email)) {
                return ResponseDTO.setFailed("중복된 Email 입니다.");
            }
        } catch (Exception e) {
        	e.printStackTrace();
            return ResponseDTO.setFailed("데이터베이스 연결에 실패하였습니다.");
        }

        // password 중복 확인
        if(!password.equals(confirmPassword)) {
            return ResponseDTO.setFailed("비밀번호가 일치하지 않습니다.");
        }

        // UserEntity 생성
        UserEntity userEntity = new UserEntity(dto);
        
     // 비밀번호 암호화
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);

        boolean isPasswordMatch = passwordEncoder.matches(password, hashedPassword);

        if(!isPasswordMatch) {
            return ResponseDTO.setFailed("암호화에 실패하였습니다.");
        }

        userEntity.setPassword(hashedPassword);


        // UserRepository를 이용하여 DB에 Entity 저장 (데이터 적재)
        try {
            userRepository.save(userEntity);
        } catch (Exception e) {
        	e.printStackTrace();
            return ResponseDTO.setFailed("데이터베이스 연결에 실패하였습니다.");
        }

        return ResponseDTO.setSuccess("회원 생성에 성공했습니다.");
    }
    public ResponseDTO<LoginResponseDTO> login(LoginDTO dto) {
        String email = dto.getEmail();
        System.out.println("email은:"+email);
        String password = dto.getPassword();
        System.out.println("비번은:"+password);
        UserEntity userEntity;
        
        try {
        	// 이메일로 사용자 정보 가져오기
            userEntity = userRepository.findById(email).orElse(null);
            if(userEntity == null) {
                return ResponseDTO.setFailed("입력하신 이메일로 등록된 계정이 존재하지 않습니다.");
            }
            // 사용자가 입력한 비밀번호를 BCryptPasswordEncoder를 사용하여 암호화
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = userEntity.getPassword();
            // 저장된 암호화된 비밀번호와 입력된 암호화된 비밀번호 비교
            if(!passwordEncoder.matches(password, encodedPassword)) {
                return ResponseDTO.setFailed("비밀번호가 일치하지 않습니다.");
            }      
        } catch (Exception e) {
        	e.printStackTrace();
            return ResponseDTO.setFailed("데이터베이스 연결에 실패하였습니다.");
        }
        // Client에 비밀번호 제공 방지
        userEntity.setPassword("");
        String name = userEntity.getName();
       

        try {
            // 값이 존재하는 경우 사용자 정보 불러옴 (기준 email)
            userEntity = userRepository.findById(email).get();
        } catch (Exception e) {
        	e.printStackTrace();
            return ResponseDTO.setFailed("데이터베이스 연결에 실패하였습니다.");
        }

        userEntity.setPassword("");

        int exprTime = 3600;     // 1h
        String token = tokenProvider.createJwt(email, exprTime);
        if(token == null) {
        	return ResponseDTO.setFailed("토큰 생성에 실패하였습니다.");
        }

        LoginResponseDTO loginResponseDto = new LoginResponseDTO(token, exprTime, userEntity);

        return ResponseDTO.setSuccessData(name+ "님, 로그인에 성공하였습니다.", loginResponseDto);
    }
}
