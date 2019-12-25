package chat.app.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User extends BaseEntity {

  private User() {
  }

  public User(String username, String password, String nickname) {
    super(username, password);
    this.nickname = nickname;
  }

  private String nickname;

  public String getNickname() {
    return nickname;
  }

  void setNickname(String nickname) {
    this.nickname = nickname;
  }
}
