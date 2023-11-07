package collabo.collaboo.global.exception;

import lombok.Getter;
@Getter
public enum ExceptionCode {
    PROJECT_NOT_FOUND("프로젝트를 찾을 수 없습니다.",404),
    TASK_NOT_FOUND("할 일을 찾을 수 없습니다.", 404),
    USER_NOT_FOUND("유저를 찾을 수 없습니다.", 404);

    private String msg;
    private Integer code;

    ExceptionCode(String msg, Integer code) {
        this.msg = msg;
        this.code = code;
    }
}
