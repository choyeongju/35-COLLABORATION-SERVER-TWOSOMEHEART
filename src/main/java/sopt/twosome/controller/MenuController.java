package sopt.twosome.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sopt.twosome.dto.common.SuccessResponse;
import sopt.twosome.dto.response.TaskDetailDto;
import sopt.twosome.exception.SuccessCode;
import sopt.twosome.service.Menu.MenuService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MenuController {

    private final MenuService menuService;

    // 메뉴 상세 정보 가져오기
    @GetMapping("v1/menu/{menuId}")
    public ResponseEntity<SuccessResponse<TaskDetailDto>> getMenuDetails(
            @RequestHeader("Authorization") long memberId,
            @PathVariable("menuId") long menuId
    ) {
        TaskDetailDto menuDetails = menuService.getMenuDetails(memberId, menuId);
        return ResponseEntity.ok(SuccessResponse.of(SuccessCode.GET_MENU_DETAIL, menuDetails));
    }
}