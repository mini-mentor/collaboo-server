package collabo.collaboo.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", updatable = false)
    private Long id; // 프로젝트 아이디

    @Column(name = "title", nullable = false)
    private String title; // 프로젝트 이름

    @Column(name = "info", nullable = false)
    private String info; // 프로젝트 정보

    @Column(name = "progress ", nullable = false)
    private Long progress; // 진행상황

    @Column(name = "people ", nullable = false)
    private Long people; // 진행상황

    @Column(name = "deadline ", nullable = false)
    private String deadline; // 진행상황

    @Column(name = "user_id", nullable = false)
    private Long userId;


    @Builder
    public Project(Long id,String title,String info, Long progress,Long people,String deadline,Long userId) {
        this.id = id;
        this.title = title;
        this.progress=progress;
        this.people=people;
        this.deadline=deadline;
        this.userId=userId;

    }

    public void update(String title, String info, String deadline, long people, long progress) {
    }
}
