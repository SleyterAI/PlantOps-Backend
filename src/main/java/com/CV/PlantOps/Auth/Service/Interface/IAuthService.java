package com.CV.PlantOps.Auth.Service.Interface;

import com.CV.PlantOps.Auth.Dto.LoginRequest;
import com.CV.PlantOps.Auth.Dto.LoginResponse;

public interface IAuthService {
    LoginResponse login(LoginRequest loginRequestDto);
}
