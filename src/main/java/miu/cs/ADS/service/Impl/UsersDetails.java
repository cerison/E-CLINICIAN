package miu.cs.ADS.service.Impl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import miu.cs.ADS.model.Role;
import miu.cs.ADS.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UsersDetails implements UserDetails {

    private String email;
    @JsonIgnore
    private String password;
    private List<Role> roles;

    public UsersDetails(User user) {
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.roles = user.getRoles();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleName().toString()))
                .collect(Collectors.toList());
    }

    public Boolean hasRole() {
        return roles.size() > 0 ? true : false;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}