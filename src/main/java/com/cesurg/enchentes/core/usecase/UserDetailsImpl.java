package com.cesurg.enchentes.core.usecase;

import com.cesurg.enchentes.core.domain.entity.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class UserDetailsImpl implements UserDetails {

    private int id;
    private String email;
    private String password;
    private String username;

    public static UserDetailsImpl build(Usuario usuario){
        return new UserDetailsImpl(
                usuario.getEmail(),
                usuario.getId(),
                usuario.getNome(),
                usuario.getSenha(),
                new ArrayList<>()
        );
    }

    private Collection<? extends GrantedAuthority> authorities;



    public UserDetailsImpl(String email, int id, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        this.email = email;
        this.id = id;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

}
