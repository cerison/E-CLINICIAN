package miu.cs.ADS.service;

import miu.cs.ADS.dto.request.LoginRequest;
import miu.cs.ADS.dto.request.RefreshTokenRequest;
import miu.cs.ADS.dto.request.RegisterRequest;
import miu.cs.ADS.dto.response.LoginResponse;

public interface AuthService {
    void register(RegisterRequest registerRequest);
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);

}
