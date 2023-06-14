package collabo.collaboo.repository;

import collabo.collaboo.domain.Project;
import collabo.collaboo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, String> {
}
