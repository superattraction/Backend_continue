package edu.pnu.config;

import edu.pnu.domain.Role;
import edu.pnu.domain.UserEntity;
import edu.pnu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserEntity> userOpt = userRepository.findByEmail(email);
        if (userOpt.isEmpty()) {
            throw new UsernameNotFoundException(email);
        }
        UserEntity user = userOpt.get();
        return (UserDetails) UserEntity.builder()
                .email(user.getEmail())
                .password(user.getPassword())
                .user_type(Role.valueOf(user.getUser_type().name()))
                .build();
    }
}
