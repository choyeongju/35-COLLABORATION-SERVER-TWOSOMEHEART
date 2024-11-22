package sopt.twosome.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sopt.twosome.dto.common.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DuplicateOptionException.class)
    public ResponseEntity<ErrorResponse> handleDuplicateOptionException(DuplicateOptionException e) {
        ErrorCode errorCode = e.getErrorCode();
        ErrorResponse errorResponse = new ErrorResponse(errorCode.getHttpStatus().value());
        return ResponseEntity.status(errorCode.getHttpStatus())
                .body(errorResponse);
    }

    @ExceptionHandler(InvalidArgsException.class)
    public ResponseEntity<ErrorResponse> handleInvalidArgsException(InvalidArgsException e) {
        ErrorCode errorCode = e.getErrorCode();
        ErrorResponse errorResponse = new ErrorResponse(errorCode.getHttpStatus().value());
        return ResponseEntity.status(errorCode.getHttpStatus())
                .body(errorResponse);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException e) {
        ErrorCode errorCode = e.getErrorCode();
        ErrorResponse errorResponse = new ErrorResponse(errorCode.getHttpStatus().value());
        return ResponseEntity.status(errorCode.getHttpStatus())
                .body(errorResponse);

    }
}
