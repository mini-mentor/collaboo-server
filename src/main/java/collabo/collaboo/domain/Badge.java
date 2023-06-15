package collabo.collaboo.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Badge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;



    @Builder
    public Badge(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void update(Long id,  String name) {
        this.id = id;
        this.name = name;
    }
}
