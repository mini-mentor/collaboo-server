package collabo.collaboo.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GenericException extends RuntimeException {
    private final ExceptionCode info;
}
