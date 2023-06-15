package collabo.collaboo.controller;

import collabo.collaboo.domain.Badge;
import collabo.collaboo.domain.Task;
import collabo.collaboo.dto.Badge.BadgeResponse;
import collabo.collaboo.dto.task.AddTaskRequest;
import collabo.collaboo.dto.task.TaskResponse;
import collabo.collaboo.dto.task.UpdateTaskRequest;
import collabo.collaboo.service.BadgeService;
import collabo.collaboo.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BadgeController {
    private final BadgeService badgeService;

    @GetMapping("/badges")
    public ResponseEntity<List<BadgeResponse>> findAllBadges() {
        List<BadgeResponse> badgeResponses = badgeService.findAll()
                .stream()
                .map(BadgeResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(articles);
    }

    @GetMapping("/badge_log")
    public ResponseEntity<List<BadgeResponse>> findAllBadges() {
        List<BadgeResponse> articles = badgeService.findAll()
                .stream()
                .map(BadgeResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(articles);
    }
}

