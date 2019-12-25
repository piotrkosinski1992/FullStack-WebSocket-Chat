package chat.app.gateways;

import chat.app.domain.BaseEntity;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseEntityRepository extends JpaRepository<BaseEntity, UUID> {
  Optional<BaseEntity> findByCredentialsUsername(String username);
}
