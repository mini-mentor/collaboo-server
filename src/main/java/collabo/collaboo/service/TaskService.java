package collabo.collaboo.service;

import collabo.collaboo.domain.Task;
import collabo.collaboo.dto.task.AddTaskRequest;
import collabo.collaboo.dto.task.UpdateTaskRequest;
import collabo.collaboo.repository.TaskRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public Task save(AddTaskRequest request) {
        return taskRepository.save(request.toEntity());
    }

    public List<Task> findAll() {
        return  taskRepository.findAll();
    }

    public Task findById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    public void delete(long id) {
        taskRepository.deleteById(id);
    }

    @Transactional
    public Task update(long id, UpdateTaskRequest request) {
        Task article = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        article.update(request.getContent(), request.getIsCompelete());

        return article;
    }
}