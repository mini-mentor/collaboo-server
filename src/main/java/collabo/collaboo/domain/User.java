package collabo.collaboo.domain;

import jakarta.persistence.*;
        import lombok.AccessLevel;
        import lombok.Builder;
        import lombok.Getter;
        import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User {
    private Object GenerationType;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private String Id;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "user_pw", nullable = false)
    private String userPw;


    @Builder
    public User(String userName, String userId, String userPw, String Id) {
        this.userName = userName;
        this.userId = userId;
        this.userPw = userPw;
        this.Id=Id;
    }

    public void update(String userName,
                       String userId,
                       String userPw,
                       String Id) {

        this.userName = userName;
        this.userId = userId;
        this.userPw = userPw;
        this.Id=Id;
    }
}
