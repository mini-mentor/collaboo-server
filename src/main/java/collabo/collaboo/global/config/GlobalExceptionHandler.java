package collabo.collaboo.global.config;


import collabo.collaboo.global.dto.ErrorResponseDto;
import collabo.collaboo.global.exception.GenericException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// controller에서 발생하는 에러 처리
@RestControllerAdvice
public class GlobalExceptionHandler {

    // GenericException 타입의 에러를 핸들링
    @ExceptionHandler(GenericException.class)
    public ResponseEntity<ErrorResponseDto> genericExceptionHandler(GenericException ex) {
        return ResponseEntity.status(ex.getInfo().getCode())
                .body(new ErrorResponseDto(ex.getInfo().getMsg()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> exceptionHandler(Exception ex) {
        System.out.println("ex.getStackTrace() = " + ex.getStackTrace());

        return ResponseEntity.internalServerError()
                .body(new ErrorResponseDto("서버에서 에러가 발생하였습니다."));
    }
}
