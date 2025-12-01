package com.example.event_streaming.service;


import com.example.event_streaming.dto.LoginUserDto;
import com.example.event_streaming.model.User;
import com.example.event_streaming.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


public class AuthService {



    @Service
    public class AuthenticationService {
        private final UserRepository userRepository;

        private final PasswordEncoder passwordEncoder;

        private final AuthenticationManager authenticationManager;

        public AuthenticationService(
                UserRepository userRepository,
                AuthenticationManager authenticationManager,
                PasswordEncoder passwordEncoder
        ) {
            this.authenticationManager = authenticationManager;
            this.userRepository = userRepository;
            this.passwordEncoder = passwordEncoder;
        }


        public User authenticate(LoginUserDto input) {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            input.getUsername(),
                            input.getPassword()
                    )
            );

            return userRepository.findByUsername(input.getUsername())
                    .orElseThrow();
        }
    }
}
