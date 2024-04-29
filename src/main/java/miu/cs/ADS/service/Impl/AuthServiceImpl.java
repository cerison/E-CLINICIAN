package miu.cs.ADS.service.Impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import miu.cs.ADS.dto.request.LoginRequest;
import miu.cs.ADS.dto.request.RefreshTokenRequest;
import miu.cs.ADS.dto.request.RegisterRequest;
import miu.cs.ADS.dto.response.LoginResponse;
import miu.cs.ADS.model.User;
import miu.cs.ADS.repository.UserRepository;
import miu.cs.ADS.service.AuthService;
import miu.cs.ADS.util.JwtUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;
    @Override
    public void register(RegisterRequest registerRequest) {
        try {
            User user = modelMapper.map(registerRequest, User.class);
            user.setPassword(bCryptPasswordEncoder.encode(registerRequest.getPassword()));
            userRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public LoginResponse login(LoginRequest loginRequest) {

        try {

            Authentication result = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
            );

            final UserDetails userDetails = userDetailsService.loadUserByUsername(result.getName());

            if(userDetails.getAuthorities().size() > 0){
                final String accessToken = jwtUtil.generateToken(userDetails);
                final String refreshToken = jwtUtil.generateRefreshToken(loginRequest.getEmail());
                var loginResponse = new LoginResponse(accessToken, refreshToken);
                return loginResponse;
            }else {
                throw new BadCredentialsException("User has no roles");
            }

        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(e.getMessage());
        }
    }

    @Override
    public LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        boolean isRefreshTokenValid = jwtUtil.validateToken(refreshTokenRequest.getRefreshToken());
        if (isRefreshTokenValid) {
            var isAccessTokenExpired = jwtUtil.isTokenExpired(refreshTokenRequest.getAccessToken());
            if(isAccessTokenExpired)
                System.out.println("ACCESS TOKEN IS EXPIRED");
            else
                System.out.println("ACCESS TOKEN IS NOT EXPIRED");

            final String accessToken = jwtUtil.doGenerateToken(  jwtUtil.getSubject(refreshTokenRequest.getRefreshToken()));
            var loginResponse = new LoginResponse(accessToken, refreshTokenRequest.getRefreshToken());
            return loginResponse;
        }
        return new LoginResponse();
    }
}