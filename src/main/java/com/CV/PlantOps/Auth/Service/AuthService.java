package com.CV.PlantOps.Auth.Service;

import com.CV.PlantOps.Auth.Dto.LoginRequest;
import com.CV.PlantOps.Auth.Dto.LoginResponse;
import com.CV.PlantOps.Auth.Service.Interface.IAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService implements IAuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public LoginResponse login(LoginRequest LoginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        LoginRequest.getEmail(),
                        LoginRequest.getPassword()
                ));
        String token = jwtService.generarToken(authentication);
        return new LoginResponse(token);
    }
}
