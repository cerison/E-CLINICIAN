package miu.cs.ADS.controller;

import miu.cs.ADS.dto.request.LoginRequest;
import miu.cs.ADS.dto.request.RefreshTokenRequest;
import miu.cs.ADS.dto.request.RegisterRequest;
import miu.cs.ADS.dto.response.LoginResponse;
import miu.cs.ADS.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ads/api/v1/auth")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    public void register(@RequestBody RegisterRequest registerRequest) {
        authService.register(registerRequest);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping("/refreshToken")
    public LoginResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return authService.refreshToken(refreshTokenRequest);
    }
}
