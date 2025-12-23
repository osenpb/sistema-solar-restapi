package com.dawi.dawi_restapi.auth.infraestructure.controllers;


import com.dawi.dawi_restapi.auth.application.mappers.AuthMapper;
import com.dawi.dawi_restapi.auth.domain.models.User;
import com.dawi.dawi_restapi.auth.domain.services.AuthService;
import com.dawi.dawi_restapi.auth.domain.services.UserService;
import com.dawi.dawi_restapi.auth.infraestructure.dtos.AuthResponse;
import com.dawi.dawi_restapi.auth.infraestructure.dtos.LoginRequest;
import com.dawi.dawi_restapi.auth.infraestructure.dtos.RegisterRequest;
import com.dawi.dawi_restapi.auth.infraestructure.dtos.UserResponse;
import com.dawi.dawi_restapi.helpers.exceptions.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;


    @PostMapping("/register")
    public ResponseEntity<AuthResponse> createUser(@RequestBody RegisterRequest createUserDto) {
        // 1. Crear el usuario
        authService.createUser(createUserDto);

        // 2. Hacer login automático para obtener token
        LoginRequest loginRequest = new LoginRequest(createUserDto.email(), createUserDto.password());
        Map<String, String> token = authService.login(loginRequest);

        // 3. Obtener usuario creado
        User user = userService.findByEmail(createUserDto.email()).orElseThrow();
        UserResponse userResponseDTO = AuthMapper.toDto(user);

        // 4. Devolver AuthResponse con token (igual que login)
        AuthResponse authResponse = new AuthResponse(userResponseDTO, token.get("access-token"));
        return ResponseEntity.status(HttpStatus.CREATED).body(authResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequestDTO) {

        try{
            final Map<String, String> token = authService.login(loginRequestDTO);
            User user = userService.findByEmail(loginRequestDTO.email()).orElseThrow();
            UserResponse userResponseDTO= AuthMapper.toDto(user);

            AuthResponse authResponseDTO = new AuthResponse(userResponseDTO, token.get("access-token"));
            return ResponseEntity.ok(authResponseDTO);

        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("No existe el usuario {}", e);
        }
    }

    @GetMapping("/saludo")
    public ResponseEntity<?> saludo() {
        return ResponseEntity.ok("hola");
    }

    @GetMapping("/me")
    public ResponseEntity<UserResponse> getCurrentUser(@AuthenticationPrincipal User user) {


            User myUser = userService.findByEmail(user.getEmail())
                    .orElseThrow(() -> new EntityNotFoundException("User not found with user {}", user.getEmail() ));

            UserResponse userResponse = AuthMapper.toDto(user);
            return ResponseEntity.ok(userResponse);

    }

}

// La otra alternativa es trabajarlo con cookies, lo dejo para luego:
//            ResponseCookie cookie = ResponseCookie.from("access-token", tokens.get("access-token"))
//                    .httpOnly(true)
//                    .secure(true)
//                    .sameSite("Strict")
//                    .path("/")
//                    .maxAge(60*60)
//                    .build();