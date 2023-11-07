package collabo.collaboo.controller;

import collabo.collaboo.dto.Badge.BadgeResponse;
import collabo.collaboo.service.BadgeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BadgeController {
    private final BadgeService badgeService;

    @GetMapping("/badges")
    public ResponseEntity<List<BadgeResponse>> findAllBadges() {
        List<BadgeResponse> badges = badgeService.findAll()
                .stream()
                .map(BadgeResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(badges);
    }

    @GetMapping("/badge_log")
    public ResponseEntity<List<BadgeResponse>> findAllBadgeLog() {
        List<BadgeResponse> articles = badgeService.findAll()
                .stream()
                .map(BadgeResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(articles);
    }
}

