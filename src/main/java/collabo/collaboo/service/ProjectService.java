package collabo.collaboo.service;

import collabo.collaboo.domain.Project;
import collabo.collaboo.dto.project.AddProjectRequest;
import collabo.collaboo.dto.project.UpdateProjectRequest;
import collabo.collaboo.exception.project.ProjectNotFoundException;
import collabo.collaboo.exception.task.TaskNotFoundException;
import collabo.collaboo.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class ProjectService {
    private final ProjectRepository projectRepository;

    public Project save(AddProjectRequest request) {
        return projectRepository.save(request.toEntity());
    }

    @Transactional(readOnly = true)
    public List<Project> findAll() {
        return  projectRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Project findById(Long id) {
        Optional<Project> findProject = projectRepository.findById(String.valueOf(id));
        if (findProject.isEmpty()) throw new ProjectNotFoundException();

        return findProject.get();
    }

    public void delete(long id) {
        projectRepository.deleteById(String.valueOf(id));
    }

    public Project update(long id, UpdateProjectRequest request) {
        Optional<Project> findArticle = projectRepository.findById(String.valueOf(id));
        if (findArticle.isEmpty()) throw new TaskNotFoundException();
        Project article = findArticle.get();

        article.update(request.getTitle(), request.getInfo(),request.getDeadline(),request.getPeople(),request.getProgress());

        return article;
    }
}

