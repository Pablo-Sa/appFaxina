package br.com.clean.house.config.security;

import br.com.clean.house.entity.AccessCredentials;
import br.com.clean.house.service.security.AccessCredentialsService;
import br.com.clean.house.service.security.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class AutenticationTokenFilter extends OncePerRequestFilter{

    private AccessCredentialsService accessCredentialsService;
    private TokenService tokenService;

    public AutenticationTokenFilter(TokenService tokenService, AccessCredentialsService accessCredentialsService) {
        this.tokenService = tokenService;
        this.accessCredentialsService = accessCredentialsService;
    }

    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String token = recoverToken(request);
        log.info("Token Recovered {}", token);

        boolean tokenValid = tokenService.isTokenValid(token);
        if(tokenValid) {
            authenticateClient(token);
        }

        filterChain.doFilter(request, response);
    }

    private void authenticateClient(String token) {
        String idUser = this.tokenService.getIdUser(token);
        AccessCredentials user = this.accessCredentialsService.findById(idUser).get();
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private String recoverToken(HttpServletRequest request) {
        String tokenRecover = request.getHeader("Authorization");

        if(tokenRecover == null || tokenRecover.isEmpty() || !tokenRecover.startsWith("Bearer ")) {
            return null;
        }

        return tokenRecover.substring(7, tokenRecover.length());
    }

}
