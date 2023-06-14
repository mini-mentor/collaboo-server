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
    @Column(name = "project_id", updatable = false)
    private Long project_id; // 프로젝트 아이디

    @Column(name = "name", nullable = false)
    private String name; // 프로젝트 이름

    @Column(name = "info", nullable = false)
    private String info; // 프로젝트 정보

    @Column(name = "progress ", nullable = false)
    private String progress; // 진행상황


    @Builder
    public Project(String name, String info, String progress) {
        this.name = name;
        this.info = info;
        this.progress=progress;
    }
}
