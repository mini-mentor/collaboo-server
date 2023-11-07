package collabo.collaboo.exception.task;

import collabo.collaboo.global.exception.ExceptionCode;
import collabo.collaboo.global.exception.GenericException;

public class TaskNotFoundException extends GenericException {
    public TaskNotFoundException() {
        super(ExceptionCode.TASK_NOT_FOUND);
    }
}
