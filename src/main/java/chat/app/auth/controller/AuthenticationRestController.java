package chat.app.auth.controller;


import chat.app.auth.jwt.TokenGenerator;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationRestController {

  private final AuthenticationManager authenticationManager;
  private Collection<? extends GrantedAuthority> authorities;

  public AuthenticationRestController(AuthenticationManager authenticationManager) {
    this.authenticationManager = authenticationManager;
  }

  @PostMapping("/auth")
  public ResponseEntity<?> createAuthenticationToken(
    @RequestBody JwtAuthenticationRequest authenticationRequest) {

    if (!authenticationSucceed(authenticationRequest.getUsername(),
      authenticationRequest.getPassword())) {
      throw new EntityNotFoundException("Wrong username or password!");
    }
    final String token = TokenGenerator.generate(authenticationRequest.getUsername(), authorities);
    return ResponseEntity.ok(new JwtAuthenticationResponse(token));
  }

  private boolean authenticationSucceed(String username, String password) {
    Objects.requireNonNull(username);
    Objects.requireNonNull(password);

    try {
      Authentication authentication = authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(username, password));
      authorities = authentication.getAuthorities();
    } catch (Exception e) {
      return false;
    }
    return true;
  }
}
