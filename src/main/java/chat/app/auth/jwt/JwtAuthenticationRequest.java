package chat.app.auth.jwt;

import java.io.Serializable;

public class JwtAuthenticationRequest implements Serializable {

  private static final long serialVersionUID = -8445943548965154778L;

  private String username;
  private String password;

  private JwtAuthenticationRequest() {
  }

  public String getUsername() {
    return this.username;
  }

  public String getPassword() {
    return this.password;
  }

  void setUsername(String username) {
    this.username = username;
  }

  void setPassword(String password) {
    this.password = password;
  }
}
