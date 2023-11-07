package collabo.collaboo.dto.Badge;

import collabo.collaboo.domain.Badge;
import lombok.Getter;

@Getter
public class BadgeResponse {
    private final String name;


    public BadgeResponse(Badge badge) {
        this.name = badge.getName();

    }
}