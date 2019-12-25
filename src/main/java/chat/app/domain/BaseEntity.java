package chat.app.domain;

import java.util.Objects;
import java.util.UUID;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CREDENTIALS")
public class BaseEntity {

  @Id
  private UUID id;

  @Embedded
  private Credentials credentials;

  @Enumerated(EnumType.STRING)
  private Role role = Role.WORKER;

  public BaseEntity() {
  }

  public BaseEntity(String username, String password) {
    this.credentials = Credentials.create(username, password);
    this.id = UUID.randomUUID();
  }

  public UUID getId() {
    return id;
  }

  public Credentials getCredentials() {
    return credentials;
  }

  public Role getRole() {
    return role;
  }

  public String getUsername() {
    return credentials.getUsername();
  }

  public String getPassword() {
    return credentials.getPassword();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BaseEntity that = (BaseEntity) o;
    return id.equals(that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
