package collabo.collaboo.exception.user;

import collabo.collaboo.global.exception.ExceptionCode;
import collabo.collaboo.global.exception.GenericException;

public class UserNotFoundException extends GenericException {
    public UserNotFoundException() {
        super(ExceptionCode.USER_NOT_FOUND);
    }
}
