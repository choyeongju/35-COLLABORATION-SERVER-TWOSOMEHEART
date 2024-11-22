package sopt.twosome.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessCode {

    GET_MENU_DETAIL(HttpStatus.OK),
    GET_LIKES_MENU_LIST(HttpStatus.OK),
    GET_LIKES_MENU_DETAIL(HttpStatus.OK),
    DELETE_FAVORITES(HttpStatus.OK),

    POST_LIKES_MENU(HttpStatus.CREATED),

    DELETE_LIKES_MENU(HttpStatus.NO_CONTENT)
    ;

    private final HttpStatus httpStatus;

}
