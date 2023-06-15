package collabo.collaboo.dto.Badge;

import collabo.collaboo.domain.Badge;
import collabo.collaboo.domain.Project;
import collabo.collaboo.domain.Task;
import lombok.Getter;

@Getter
public class BadgeResponse {
    private final String name;


    public BadgeResponse(Badge badge) {
        this.name = badge.getName();

    }
}