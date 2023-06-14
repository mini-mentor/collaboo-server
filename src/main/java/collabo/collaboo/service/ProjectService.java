package collabo.collaboo.service;

import collabo.collaboo.domain.Project;
import collabo.collaboo.domain.Task;
import collabo.collaboo.dto.project.AddProjectRequest;
import collabo.collaboo.dto.project.UpdateProjectRequest;
import collabo.collaboo.dto.task.AddTaskRequest;
import collabo.collaboo.dto.task.UpdateTaskRequest;
import collabo.collaboo.repository.ProjectRepository;
import collabo.collaboo.repository.TaskRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    public Project save(AddProjectRequest request) {
        return projectRepository.save(request.toEntity());
    }

    public List<Project> findAll() {
        return  projectRepository.findAll();
    }

    public Project findById(Long id) {
        return projectRepository.findById(String.valueOf(id))
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    public void delete(long id) {
        projectRepository.deleteById(String.valueOf(id));
    }

    @Transactional
    public Project update(long id, UpdateProjectRequest request) {
        Project article = projectRepository.findById(String.valueOf(id))
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        article.update(request.getTitle(), request.getInfo(),request.getDeadline(),request.getPeople(),request.getProgress());

        return article;
    }
}

