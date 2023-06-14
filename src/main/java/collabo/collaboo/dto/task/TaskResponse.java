package collabo.collaboo.dto.task;

import collabo.collaboo.domain.Task;
import lombok.Getter;

@Getter
public class TaskResponse {
    private final String content;
    private final Boolean isComplete;

    public TaskResponse(Task task) {
        this.content = task.getContent();
        this.isComplete = task.getIsComplete();
    }
}