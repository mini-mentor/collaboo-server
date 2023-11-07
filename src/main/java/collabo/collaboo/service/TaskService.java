package collabo.collaboo.service;

import collabo.collaboo.domain.Task;
import collabo.collaboo.dto.task.AddTaskRequest;
import collabo.collaboo.dto.task.UpdateTaskRequest;
import collabo.collaboo.exception.task.TaskNotFoundException;
import collabo.collaboo.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
        Optional<Task> task = taskRepository.findById(id);
        if (task.isEmpty()) throw new TaskNotFoundException();

        return task.get();
    }

    public void delete(long id) {
        taskRepository.deleteById(id);
    }

    public Task update(long id, UpdateTaskRequest request) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isEmpty()) throw new TaskNotFoundException();

        task.get().update(request.getContent(), request.getIsCompelete());

        return task.get();
    }
}