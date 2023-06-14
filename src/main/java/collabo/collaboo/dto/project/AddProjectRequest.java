package collabo.collaboo.dto.project;

import collabo.collaboo.domain.Project;
import collabo.collaboo.domain.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddProjectRequest {
    private String title;
    private String info;
    private  long progress;
    private  long people;
    private String deadline;

    public Project toEntity() {
        return Project.builder()
                .title(title)
                .info(info)
                .progress(progress)
                .people(people)
                .deadline(deadline)
                .build();
    }
}