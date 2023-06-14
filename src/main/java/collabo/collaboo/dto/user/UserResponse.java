package collabo.collaboo.dto.user;

import lombok.Getter;

@Getter
public class UserResponse {
    private final String userName;
    private final String userId;
    private final String userPw;
    private final String Id;

    public <User> UserResponse(User user){
        this.Id = user.getId();
        this.userName = user.getUserName();
        this.userId = user.getUserId();
        this.userPw = user.getUserPw();

    }
}
