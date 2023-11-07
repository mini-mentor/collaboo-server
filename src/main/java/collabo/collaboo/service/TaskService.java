package collabo.collaboo.service;

import collabo.collaboo.domain.Task;
import collabo.collaboo.dto.task.AddTaskRequest;
import collabo.collaboo.dto.task.UpdateTaskRequest;
import collabo.collaboo.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class TaskService {
    private final TaskRepository taskRepository;

    public Task save(AddTaskRequest request) {
        return taskRepository.save(request.toEntity());
    }

    @Transactional(readOnly = true) // 읽기 전용 트랜잭션은 성능을 향상 시켜줌.
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

    public Task update(long id, UpdateTaskRequest request) {
        Task article = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        article.update(request.getContent(), request.getIsCompelete());

        return article;
    }
}