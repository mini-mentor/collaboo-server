package collabo.collaboo.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddUserRequest {
    private String userName;
    private String userId;
    private String userPw;
    private String Id;

    public <User> User toEntity(){
        return User.builder()
                .userName(userName)
                .userId(userId)
                .userPw(userPw)
                .Id(Id)
                .build();

    }
}

