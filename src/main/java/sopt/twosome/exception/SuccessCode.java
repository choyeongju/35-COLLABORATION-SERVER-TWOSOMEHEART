package sopt.twosome.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessCode {
    GET_LIKES_MENU_LIST(HttpStatus.OK),
    POST_LIKES_MENU(HttpStatus.CREATED),
    DELETE_LIKES_MENU(HttpStatus.NO_CONTENT),
    GET_LIKES_MENU_DETAIL(HttpStatus.OK);

    private final HttpStatus httpStatus;

}
