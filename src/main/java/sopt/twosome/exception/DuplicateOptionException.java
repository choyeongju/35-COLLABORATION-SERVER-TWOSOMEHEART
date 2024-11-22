package sopt.twosome.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class DuplicateOptionException extends RuntimeException {
    private final ErrorCode errorCode;
}
