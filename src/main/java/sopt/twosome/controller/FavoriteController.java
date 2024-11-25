package sopt.twosome.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sopt.twosome.dto.common.SuccessResponse;
import sopt.twosome.dto.request.FavoriteCreateRequest;
import sopt.twosome.dto.response.FavoriteListResponse;
import sopt.twosome.exception.SuccessCode;

import sopt.twosome.service.Favorite.FavoriteService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class FavoriteController {

    private final FavoriteService favoriteService;

    // 메뉴 즐겨찾기
    @PostMapping("/v1/menu/{menuId}/likes")
    ResponseEntity<SuccessResponse<Void>> addMenuToFavorites(
            @RequestHeader("Authorization") long memberId,
            @Valid @PathVariable(name = "menuId") long menuId,
            @RequestBody FavoriteCreateRequest favoriteCreateRequest
    ) {
        favoriteService.createFavorite(menuId, memberId, favoriteCreateRequest);
        return ResponseEntity.ok(SuccessResponse.of(SuccessCode.POST_LIKES_MENU));
    }

    // 즐겨찾기 메뉴 삭제
    @DeleteMapping("/v1/likes")
    public ResponseEntity<SuccessResponse<Void>> deleteFavorites(
            @RequestHeader("Authorization") long memberId,
            @RequestParam(value = "favoriteIds", required = false) String favoriteIds,
            @RequestParam(value = "all", required = false) boolean all
    ){
        favoriteService.removeFavorites(memberId, favoriteIds, all);
        return ResponseEntity.ok(SuccessResponse.of(SuccessCode.DELETE_FAVORITES));
    }

    //즐겨찾기 목록 조회
    @GetMapping("/v1/likes")
    public ResponseEntity<SuccessResponse<FavoriteListResponse>> getFavorites(
            @RequestHeader("Authorization") long memberId
    ) {
        FavoriteListResponse favoriteListResponse = favoriteService.getListFavorites(memberId);
        return ResponseEntity.ok(SuccessResponse.of(SuccessCode.GET_LIKES_MENU_LIST, favoriteListResponse ));
    }
}
