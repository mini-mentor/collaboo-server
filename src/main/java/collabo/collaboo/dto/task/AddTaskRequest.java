package collabo.collaboo.dto.task;

import collabo.collaboo.domain.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddTaskRequest {
    private String content;
    private Boolean isCompelete;

    public Task toEntity() {
        return Task.builder()
                .content(content)
                .isComplete(isCompelete)
                .build();
    }
}