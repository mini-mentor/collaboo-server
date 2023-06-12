package collabo.collaboo.controller;

import collabo.collaboo.dto.GetProjectResponse;
import collabo.collaboo.dto.PostLoginResponse;
import org.springframework.web.bind.annotation.*;
import com.collaboo.collaboo.controller;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProjectController {

    @PostMapping("/projects")
    public List<GetProjectResponse> createProjects(@RequestBody List<ProjectRequest> projectRequests) {
        List<GetProjectResponse> responses = new ArrayList<>();

        for (ProjectRequest request : projectRequests) {
            int id = request.getId();
            String title = request.getTitle();
            LocalDate deadline = LocalDate.parse(request.getDeadline());

            GetProjectResponse response = GetProjectResponse.builder()
                    .id(id)
                    .title(title)
                    .deadline(deadline)
                    .user_id(user_id)
                    .info(info)
                    .people(people)
                    .progress(progress);
        }

        return responses;
    }


    @PostMapping("/projects")
    public List<GetProjectResponse> createProjects(@RequestBody List<ProjectRequest> projectRequests) {
        List<GetProjectResponse> responses = new ArrayList<>();

        for (ProjectRequest request : projectRequests) {
            int id = request.getId();
            String title = request.getTitle();
            LocalDate deadline = LocalDate.parse(request.getDeadline());

            int userId = request.getUserId();  // 예시로 user_id 값을 가져오는 로직 추가
            String info = request.getInfo();  // 예시로 info 값을 가져오는 로직 추가
            int people = request.getPeople();  // 예시로 people 값을 가져오는 로직 추가
            int progress = request.getProgress();  // 예시로 progress 값을 가져오는 로직 추가

            GetProjectResponse response = GetProjectResponse.builder()
                    .id(id)
                    .title(title)
                    .deadline(deadline)
                    .user_id(userId)  // 가져온 user_id 값을 설정
                    .info(info)  // 가져온 info 값을 설정
                    .people(people)  // 가져온 people 값을 설정
                    .progress(progress)  // 가져온 progress 값을 설정
                    .build();

            responses.add(response);
        }

        return responses;
    }


    @GetMapping("/projects/{id}")
    public GetProjectResponse get(@PathVariable int id) {
        // id를 사용하여 프로젝트 정보 조회 및 필요한 데이터 설정
        String title = "프로젝트 1";
        LocalDate deadline = LocalDate.of(2023, 8, 8);

        GetProjectResponse response = GetProjectResponse.builder()
                .title(title)
                .deadline(deadline)
                // 다른 필드들도 필요에 따라 설정
                .build();

        return response;
    }
    @PostMapping("/login")
    public PostLoginResponse post(@RequestBody LoginRequest request) {
        // 요청 본문의 JSON 데이터를 LoginRequest 객체로 변환하여 받아옴
        int id = request.getId();

        // PostLoginResponse 객체 생성 및 설정
        PostLoginResponse response = PostLoginResponse.builder()
                .id(id)
                // 다른 필드들도 필요에 따라 설정
                .build();

        return response;
    }

    @GetMapping("/projects")
    public List<ProjectResponse> getProjects() {
        List<ProjectResponse> projects = new ArrayList<>();

        ProjectResponse project1 = ProjectResponse.builder()
                .id(1)
                .userId(1)
                .title("프로젝트 1")
                .info("프로젝트 소개 2")
                .progress(0)
                .people(2)
                .deadline(LocalDate.parse("2023-08-08"))
                .build();
        projects.add(project1);

        ProjectResponse project2 = ProjectResponse.builder()
                .id(2)
                .userId(1)
                .title("프로젝트 2")
                .info("프로젝트 소개 2")
                .progress(10)
                .people(5)
                .deadline(LocalDate.parse("2023-09-09"))
                .build();
        projects.add(project2);

        ProjectResponse project3 = ProjectResponse.builder()
                .id(3)
                .userId(1)
                .title("프로젝트 3")
                .info("프로젝트 소개 3")
                .progress(20)
                .people(4)
                .deadline(LocalDate.parse("2023-10-10"))
                .build();
        projects.add(project3);

        return projects;
    }
    @PutMapping("/projects/1")
    public String updateProject(@RequestBody ProjectRequest projectRequest) {
        int id = projectRequest.getId();
        int userId = projectRequest.getUserId();
        String title = projectRequest.getTitle();
        String info = projectRequest.getInfo();
        int progress = projectRequest.getProgress();
        int people = projectRequest.getPeople();
        LocalDate deadline = LocalDate.parse(projectRequest.getDeadline());

        // 프로젝트 업데이트 로직 수행
        // ...

        return "Project updated successfully!";
    }


    @PostMapping("/sign-up")
    public String signUp(@RequestBody SignUpRequest signUpRequest) {
        int id = signUpRequest.getId();
        String nickname = signUpRequest.getNickname();
        String username = signUpRequest.getUsername();
        String password = signUpRequest.getPassword();

        // 회원가입 로직 수행
        // ...

        return "Sign-up successful!";
    }

    @GetMapping("/tasks")
    public List<TaskResponse> getTasks() {
        List<TaskResponse> tasks = new ArrayList<>();

        TaskResponse task1 = TaskResponse.builder()
                .id(1)
                .projectId(1)
                .userId(1)
                .content("할 일 1")
                .isComplete(false)
                .build();
        tasks.add(task1);

        TaskResponse task2 = TaskResponse.builder()
                .id(2)
                .projectId(1)
                .userId(1)
                .content("할 일 2")
                .isComplete(false)
                .build();
        tasks.add(task2);

        TaskResponse task3 = TaskResponse.builder()
                .id(3)
                .projectId(1)
                .userId(1)
                .content("할 일 3")
                .isComplete(false)
                .build();
        tasks.add(task3);

        return tasks;
    }


    @GetMapping("/tasks/{id}")
    public TaskResponse getTaskById(@PathVariable int id) {
        // id를 사용하여 작업 정보를 조회하는 로직 수행
        // ...

        TaskResponse task = TaskResponse.builder()
                .id(1)
                .projectId(1)
                .userId(1)
                .content("할 일 1")
                .isComplete(false)
                .build();

        return task;
    }

    @PostMapping("/tasks")
    public String createTask(@RequestBody TaskRequest taskRequest) {
        int id = taskRequest.getId();
        int projectId = taskRequest.getProjectId();
        int userId = taskRequest.getUserId();
        String content = taskRequest.getContent();
        boolean isComplete = taskRequest.isComplete();

        // 새로운 작업 생성 로직 수행
        // ...

        return "Task created successfully!";
    }
    @PutMapping("/tasks/{id}")
    public String updateTask(@PathVariable int id, @RequestBody TaskRequest taskRequest) {
        int taskId = taskRequest.getId();
        int projectId = taskRequest.getProjectId();
        int userId = taskRequest.getUserId();
        String content = taskRequest.getContent();
        boolean isComplete = taskRequest.isComplete();

        // 해당 아이디의 작업 정보 업데이트 로직 수행
        // ...

        return "Task updated successfully!";
    }
    @GetMapping("/badges")
    public List<Badge> getBadges() {
        Badge badge1 = new Badge(1, "별뱃지 1");
        Badge badge2 = new Badge(2, "별뱃지 2");
        Badge badge3 = new Badge(3, "별뱃지 3");

        List<Badge> badges = new ArrayList<>();
        badges.add(badge1);
        badges.add(badge2);
        badges.add(badge3);

        return badges;
    }
    @GetMapping("/badge_log")
    public List<BadgeLog> getBadgeLogs() {
        BadgeLog badgeLog1 = new BadgeLog(1, 1, 1);
        // 뱃지 로그 정보 생성 및 추가
        // ...

        List<BadgeLog> badgeLogs = new ArrayList<>();
        badgeLogs.add(badgeLog1);
        // 뱃지 로그 정보 추가
        // ...

        return badgeLogs;
    }



}
