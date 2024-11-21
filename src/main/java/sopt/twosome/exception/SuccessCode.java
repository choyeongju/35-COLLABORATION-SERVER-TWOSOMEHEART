package sopt.twosome.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessCode {
    SUCCESS_GET_LIKES_MENU_LIST(HttpStatus.OK),
    SUCCESS_POST_LIKES_MENU(HttpStatus.NO_CONTENT),
    SUCCESS_DELETE_LIKES_MENU(HttpStatus.OK),
    SUCCESS_GET_LIKES_MENU_DETAIL(HttpStatus.OK);

    private final HttpStatus httpStatus;

}
