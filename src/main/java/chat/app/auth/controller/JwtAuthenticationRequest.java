package chat.app.auth.controller;

import java.io.Serializable;

class JwtAuthenticationRequest implements Serializable {

  private static final long serialVersionUID = -8445943548965154778L;

  private String username;
  private String password;

  private JwtAuthenticationRequest() {
  }

  String getUsername() {
    return this.username;
  }

  String getPassword() {
    return this.password;
  }

  void setUsername(String username) {
    this.username = username;
  }

  void setPassword(String password) {
    this.password = password;
  }
}
