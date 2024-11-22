package sopt.twosome.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode{
    //1. 메뉴 상세 정보 가져오기
    NOT_FOUND_LIKES_MENU_DETAIL(HttpStatus.NOT_FOUND),

    //2. 메뉴 즐겨찾기
    //필수 옵션 선택하지 않는 경우
    INVALID_ARGUMENTS(HttpStatus.BAD_REQUEST),
    //즐겨찾기하는 메뉴의 옵션이 중복되는 경우
    DUPLICATED_MENU_OPTION(HttpStatus.BAD_REQUEST),
    //3. 즐겨찾기 메뉴 보여주기
    NOT_FOUND_LIKES_MENU_LIST(HttpStatus.NOT_FOUND),
    // 삭제하려는 것에 해당하는 즐겨찾기 메뉴 가 없는 경우
    NOT_FOUND_LIKES_MENU(HttpStatus.NOT_FOUND),

    NOT_EXISTS_MENU_WITH_ID(HttpStatus.NOT_FOUND),
    NOT_EXISTS_MEMBER_WITH_ID(HttpStatus.NOT_FOUND)
    ;

    private final HttpStatus httpStatus;
}
