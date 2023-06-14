package collabo.collaboo.dto.task;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateTaskRequest {
    private String content;
    private Boolean isCompelete;
}