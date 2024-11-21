package sopt.twosome.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class InvalidArgsException extends RuntimeException {
    private final ErrorCode errorCode;
}
