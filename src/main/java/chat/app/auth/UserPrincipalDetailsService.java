package chat.app.auth;

import chat.app.domain.BaseEntity;
import chat.app.services.LoadBaseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {

  private final LoadBaseEntity loadBaseEntity;

  public UserPrincipalDetailsService(LoadBaseEntity loadBaseEntity) {
    this.loadBaseEntity = loadBaseEntity;
  }

  @Override
  public UserDetails loadUserByUsername(String username) {
    BaseEntity baseEntity = this.loadBaseEntity.loadByUsername(username);
    return new UserPrincipal(baseEntity);
  }
}
