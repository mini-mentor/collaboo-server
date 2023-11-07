package collabo.collaboo.service;


import collabo.collaboo.domain.Badge;
import collabo.collaboo.domain.Task;
import collabo.collaboo.dto.task.AddTaskRequest;
import collabo.collaboo.dto.task.UpdateTaskRequest;
import collabo.collaboo.repository.BadgeRepository;
import collabo.collaboo.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BadgeService {

    private final BadgeRepository badgeRepository;

    // read
    public List<Badge> findAll() {
        return badgeRepository.findAll();
    }

}