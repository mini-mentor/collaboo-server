package collabo.collaboo.dto.user;

import collabo.collaboo.domain.User;
import lombok.Getter;

@Getter
public class UserResponse {
    private final Long userNo;
    private final String userName;
    private final String userId;
    private final String userPw;

    public UserResponse(User user){
        this.userNo = user.getUserNo();
        this.userName = user.getUserName();
        this.userId = user.getUserId();
        this.userPw = user.getUserPw();


    }
}
