package tech.silva.ms.email.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.silva.ms.email.entity.EmailEntity;

import java.util.UUID;

public interface EmailRepository extends JpaRepository<EmailEntity, UUID> {
}
