package com.cesurg.enchentes.core.usecase;

import com.cesurg.enchentes.Security.Jwt.JwtUtils;
import com.cesurg.enchentes.core.dto.AcessDto;
import com.cesurg.enchentes.core.dto.AuthenticationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    public AcessDto login(AuthenticationDTO authDto) {

        try {
            //Cria mecanismo de credencial para o spring
            UsernamePasswordAuthenticationToken userAuth = new UsernamePasswordAuthenticationToken(authDto.getUsername(), authDto.getPassword());


            //Prepara mecanismo para autenticação
            Authentication authentication = authenticationManager.authenticate(userAuth);

            //Busca usuario logado
            UserDetailsImpl userAuthenticate = (UserDetailsImpl) authentication.getPrincipal();

            String token = jwtUtils.generateTokenFromUserDetailsImpl(userAuthenticate);

            AcessDto acessDto = new AcessDto(token, userAuthenticate.getUsername(), userAuthenticate.getRole().name());
            return acessDto;

        } catch (BadCredentialsException e) {
            //TODO LOGIN OU SENHA INVALIDOS
            System.out.println("Login ou senha inválidos: " + e.getMessage());
        }
        return null;
    }
}
