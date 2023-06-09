package collabo.collaboo.dto.Badge;


import collabo.collaboo.domain.Badge;
import collabo.collaboo.domain.Project;
import collabo.collaboo.domain.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddBadgeRequest {
    private String name;


    public Badge toEntity() {
        return Badge.builder()
                .name(name)
                .build();
    }
}
