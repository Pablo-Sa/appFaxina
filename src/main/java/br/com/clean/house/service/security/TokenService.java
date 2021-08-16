package br.com.clean.house.service.security;

import br.com.clean.house.entity.AccessCredentials;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class TokenService {

    @Value("${jwt.expiration}")
    private String expiration;

    @Value("${jwt.secret}")
    private String secret;

    public String  generateToken(Authentication authentication) {
        AccessCredentials userLogado = (AccessCredentials) authentication.getPrincipal();
        Date today = new Date();
        Date expirationToken = new Date(today.getTime()+ Long.parseLong(this.expiration));
        log.info("Data of Expiration this Token {} ",expirationToken);
        return Jwts.builder()
                .setIssuer("Back-End Aplication Faxina")
                .setSubject(userLogado.getId())
                .setIssuedAt(today)
                .setExpiration(expirationToken)
                .signWith(SignatureAlgorithm.HS256, this.secret)
                .compact();
    }

    public boolean isTokenValid(String token) {

        try {
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return Boolean.TRUE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }

    public String getIdUser(String token) {
        Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
}
