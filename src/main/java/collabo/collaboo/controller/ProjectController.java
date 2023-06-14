package collabo.collaboo.controller;

import collabo.collaboo.domain.Project;
import collabo.collaboo.domain.Task;
import collabo.collaboo.domain.User;
import collabo.collaboo.dto.project.AddProjectRequest;
import collabo.collaboo.dto.project.ProjectResponse;
import collabo.collaboo.dto.project.UpdateProjectRequest;
import collabo.collaboo.dto.task.AddTaskRequest;
import collabo.collaboo.dto.task.TaskResponse;
import collabo.collaboo.dto.user.AddUserRequest;
import collabo.collaboo.dto.user.UpdateUserRequest;
import collabo.collaboo.dto.user.UserResponse;
import collabo.collaboo.service.ProjectService;
import collabo.collaboo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProjectController {
    private final ProjectService projectService;


    @GetMapping("/projects")
    public ResponseEntity<List<ProjectResponse>> findAllTasks() {
        List<ProjectResponse> articles = projectService.findAll()
                .stream()
                .map(ProjectResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(articles);
    }


    @GetMapping("/projects/{id}")
    public ResponseEntity<ProjectResponse> findArticle(@PathVariable long id) {
        Project project= projectService.findById(id);

        return ResponseEntity.ok()
                .body(new ProjectResponse(project));


    }

    @PostMapping("/projects")
    public ResponseEntity<Project> addArticle(@RequestBody AddProjectRequest request) {
        Project savedArticle = projectService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }

    @PutMapping("/projects/{id}")
    public ResponseEntity<Project> updateUser(@PathVariable long id,
                                              @RequestBody UpdateProjectRequest request){
        Project updatedProject = projectService.update(id,request);

        return ResponseEntity.ok().body(updatedProject);
    }

    @DeleteMapping("/projects/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id){
        projectService.delete(id);

        return ResponseEntity.ok().build();
    }
}
