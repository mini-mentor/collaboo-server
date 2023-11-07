package collabo.collaboo.dto.project;

import collabo.collaboo.domain.Project;
import lombok.Getter;

@Getter
public class ProjectResponse {
    private final String title;
    private final String info;
    private final long progress;
    private final long people;
    private final String deadline;

    public ProjectResponse(Project project) {
        this.title = project.getTitle();
        this.info = project.getInfo();
        this.progress = project.getProgress();
        this.people = project.getPeople();
        this.deadline = project.getDeadline();
    }
}
