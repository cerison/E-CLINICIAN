package miu.cs.ads_datapersisitence.controller;

import miu.cs.ads_datapersisitence.dto.request.LoginRequest;
import miu.cs.ads_datapersisitence.dto.response.LoginResponse;
import miu.cs.ads_datapersisitence.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ads/api/v1/auth")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        logger.info("Processing login request");
        return authService.login(loginRequest);
    }
}
