package collabo.collaboo.dto.project;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateProjectRequest {
    private String title;
    private String info;
    private  long progress;
    private  long people;
    private String deadline;
}
