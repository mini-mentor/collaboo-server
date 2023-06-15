package collabo.collaboo.repository;

import collabo.collaboo.domain.Badge;
import collabo.collaboo.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BadgeRepository extends JpaRepository<Badge, String> {
}
