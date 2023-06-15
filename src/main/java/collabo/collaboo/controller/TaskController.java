package collabo.collaboo.controller;

import collabo.collaboo.domain.Task;
import collabo.collaboo.dto.task.AddTaskRequest;
import collabo.collaboo.dto.task.TaskResponse;
import collabo.collaboo.dto.task.UpdateTaskRequest;
import collabo.collaboo.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TaskController {
    private final TaskService taskService;

    @GetMapping("/tasks")
    public ResponseEntity<List<TaskResponse>> findAllTasks() {
        List<TaskResponse> tasks = taskService.findAll()
                .stream()
                .map(TaskResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(tasks);
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<TaskResponse> findArticle(@PathVariable long id) {
        Task task = taskService.findById(id);

        return ResponseEntity.ok()
                .body(new TaskResponse(task));
    }

    @PostMapping("/tasks")
    public ResponseEntity<Task> addArticle(@RequestBody AddTaskRequest request) {
        Task savedArticle = taskService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }



    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable long id) {
        taskService.delete(id);

        return ResponseEntity.ok()
                .build();
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<Task> updateArticle(@PathVariable long id,
                                                 @RequestBody UpdateTaskRequest request) {
        Task updatedTask = taskService.update(id, request);

        return ResponseEntity.ok()
                .body(updatedTask);
    }
}
