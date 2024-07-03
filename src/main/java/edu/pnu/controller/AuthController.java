package edu.pnu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.dto.LoginDTO;
import edu.pnu.dto.ResponseDTO;
import edu.pnu.dto.SignUpDTO;
import edu.pnu.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/signUp")
    public ResponseDTO<?> signUp(@RequestBody SignUpDTO requestBody) {
        return authService.signUp(requestBody);
    }

    @PostMapping("/signin")
    public ResponseDTO<?> login(@RequestBody LoginDTO requestBody) {
        return authService.login(requestBody);
    }
}