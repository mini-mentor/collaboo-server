package collabo.collaboo.exception.project;

import collabo.collaboo.global.exception.ExceptionCode;
import collabo.collaboo.global.exception.GenericException;

public class ProjectNotFoundException extends GenericException {
    public ProjectNotFoundException() {
        super(ExceptionCode.PROJECT_NOT_FOUND);
    }
}
