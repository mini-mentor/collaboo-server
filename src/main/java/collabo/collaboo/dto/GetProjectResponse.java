package collabo.collaboo.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class GetProjectResponse {
    private final String title;
    private final LocalDate deadline;
    private final Integer user_id;
    private final Integer id;
    private final String info;
    private final Integer people;
    private Integer progress;




    @Builder
    public GetProjectResponse(String title,Integer id, LocalDate deadline,Integer user_id,String info,Integer people,Integer progress) {
        this.title = title;
        this.deadline = deadline;
        this.info = info;
        this.user_id = user_id;
        this.people = people;
        this.id=id;
        this.progress=progress;
    }
}
