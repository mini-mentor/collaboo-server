package collabo.collaboo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {

    @PostMapping("/project")
    public String project() {
        return "Hello!";
    }
    @GetMapping("/Projects")
    public String
    public
}
