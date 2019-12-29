package chat.app.services;

import chat.app.gateways.BaseEntityRepository;
import chat.app.domain.BaseEntity;
import org.springframework.stereotype.Service;

@Service
public class LoadBaseEntity {

  private final BaseEntityRepository repository;

  public LoadBaseEntity(BaseEntityRepository repository) {
    this.repository = repository;
  }

  public BaseEntity loadByUsername(String username) {
    return repository.findByCredentialsUsername(username).orElseThrow(
        () -> new RuntimeException("User with given username doesn't exist: " + username));
  }
}
