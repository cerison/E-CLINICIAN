package miu.cs.ADS.config;

import lombok.RequiredArgsConstructor;
import miu.cs.ADS.enums.Roles;
import miu.cs.ADS.filter.JwtFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final UserDetailsService userDetailsService;
    private final JwtFilter jwtFilter;
    @Bean
    public UserDetailsService userDetailsSvc() {
        return userDetailsService;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
            .csrf().disable()
            .authorizeRequests(authorizeRequests ->
                    authorizeRequests
                            .requestMatchers("/ads/api/v1/auth/**").permitAll()
                            .requestMatchers(HttpMethod.GET,"/ads/api/v1/patient/**").hasAnyAuthority(Roles.PATIENT.name(),Roles.MANAGER.name())
                            .requestMatchers(HttpMethod.POST,"/ads/api/v1/patient/appointment/*").hasAnyAuthority(Roles.PATIENT.name(),Roles.MANAGER.name())
                            .requestMatchers(HttpMethod.GET,"/ads/api/v1/dentist/**").hasAnyAuthority(Roles.DENTIST.name(),Roles.MANAGER.name())
                            .requestMatchers(HttpMethod.POST,"/ads/api/v1/dentist/appointment/*/*").hasAnyAuthority(Roles.DENTIST.name(),Roles.MANAGER.name())
                            .requestMatchers("/ads/api/v1/manager/addRole/*").hasAuthority(Roles.MANAGER.name())
                            .requestMatchers("/ads/api/v1/**").hasAuthority(Roles.MANAGER.name())

                            .anyRequest().authenticated()
            )
            .sessionManagement(sessionManagement ->
                    sessionManagement
                            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            );

    http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

    return http.build();
}
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/images/**", "/js/**", "/webjars/**");
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsSvc());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }
}