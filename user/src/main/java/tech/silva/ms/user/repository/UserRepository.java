package tech.silva.ms.user.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import tech.silva.ms.user.entity.UserEntity;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
}
