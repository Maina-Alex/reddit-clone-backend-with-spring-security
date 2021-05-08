package com.maina.redditBackend.Security;

import io.jsonwebtoken.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.sql.Date;
import java.time.Instant;

import static java.util.Date.from;
@Service
public class JwtProvider {
    public String generateToken(Authentication authentication){
        User principal=(User) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(principal.getUsername())
                .setIssuedAt(from(Instant.now()))
                .signWith(SignatureAlgorithm.HS512,SecurityConstants.SECRET)
                .setExpiration(Date.from(Instant.now().plusMillis(SecurityConstants.EXPIRATION_TIME)))
                .compact();
    }
    public String generateTokenWithUsername(String username){
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(from(Instant.now()))
                .signWith(SignatureAlgorithm.HS512,SecurityConstants.SECRET)
                .setExpiration(Date.from(Instant.now().plusMillis(SecurityConstants.EXPIRATION_TIME)))
                .compact();
    }
    public boolean validateToken(String jwtToken){
        try {
            Jwts.parser().setSigningKey(SecurityConstants.SECRET).parseClaimsJws(jwtToken);
            return true;
        } catch (SignatureException ex) {
            throw new RuntimeException("Invalid JWT signature ");
//            logger.error("Invalid JWT signature - {}", ex.getMessage());
        } catch (MalformedJwtException ex) {
            throw new RuntimeException("Invalid JWT token");
            /// logger.error("Invalid JWT token - {}", ex.getMessage());
        } catch (ExpiredJwtException ex) {
            throw new RuntimeException("Expired JWT token");
            //  logger.error("Expired JWT token - {}", ex.getMessage());
        } catch (UnsupportedJwtException ex) {
            throw new RuntimeException("Unsupported JWT token");
            //   logger.error("Unsupported JWT token - {}", ex.getMessage());
        } catch (IllegalArgumentException ex) {
            throw new RuntimeException("JWT claims string is empty");
            //    logger.error("JWT claims string is empty - {}", ex.getMessage());
        }
    }
    public String getUsernameFromToken(String token){
        return Jwts.parser()
                .setSigningKey(SecurityConstants.SECRET)
                .parseClaimsJws(token)
                .getBody().getSubject();
    }

}
