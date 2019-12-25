package chat.app.auth.jwt;

import static chat.app.auth.jwt.JwtProperties.EXPIRATION_TIME;
import static chat.app.auth.jwt.JwtProperties.JWT_SECRET;
import static chat.app.auth.jwt.JwtProperties.TOKEN_AUDIENCE;
import static chat.app.auth.jwt.JwtProperties.TOKEN_ISSUER;
import static chat.app.auth.jwt.JwtProperties.TOKEN_TYPE;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;

public class TokenGenerator {

  public static String generate(String username,
      Collection<? extends GrantedAuthority> authorities) {
    return Jwts.builder()
        .signWith(SignatureAlgorithm.HS256, TextCodec.BASE64.decode(JWT_SECRET))
        .setHeaderParam("typ", TOKEN_TYPE)
        .setIssuer(TOKEN_ISSUER)
        .setAudience(TOKEN_AUDIENCE)
        .setSubject(username)
        .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
        .claim("roles",
            authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
        .compact();
  }
}
