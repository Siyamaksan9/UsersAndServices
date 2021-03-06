package com.example.san.Service.Security;

import com.example.san.Model.BaseModel.San_User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

import java.util.stream.Collectors;


public class UserService implements UserDetails {
    private San_User san_user;

    public UserService(San_User user) {
        this.san_user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return san_user.getAuthorities().stream().map(authority -> new SimpleGrantedAuthority(authority.getName().toString())).collect(Collectors.toList());
    }

    public long getId() {
        return san_user.getId();
    }

    @Override
    public String getPassword() {

        return san_user.getPassword();
    }

    @Override
    public String getUsername() {
        return san_user.getUsername();
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

    public San_User getUserDetails() {
        return san_user;
    }
}
