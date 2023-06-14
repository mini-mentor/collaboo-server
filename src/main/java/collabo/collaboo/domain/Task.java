package collabo.collaboo.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "project_id", nullable = false)
    private Long projectId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "is_complete")
    private Boolean isComplete;

    @Builder
    public Task(String content, Boolean isComplete) {
        this.content = content;
        this.isComplete = isComplete;
    }

    public void update(String content, Boolean isComplete) {
        this.content = content;
        this.isComplete = isComplete;
    }
}