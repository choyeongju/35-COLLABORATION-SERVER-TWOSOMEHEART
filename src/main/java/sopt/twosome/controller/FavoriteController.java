package sopt.twosome.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sopt.twosome.dto.common.SuccessResponse;
import sopt.twosome.dto.request.FavoriteCreateRequest;
import sopt.twosome.exception.SuccessCode;

import sopt.twosome.service.Favorite.FavoriteService;

@RestController
@RequiredArgsConstructor
public class FavoriteController {
    private final FavoriteService favoriteService;

    @PostMapping("/api/v1/menu/{menuId}/likes")
    ResponseEntity<SuccessResponse<Void>> addMenuToFavorites(
            @Valid @PathVariable(name="menuId") long menuId,
            @RequestHeader(value="memberId") long memberId,
            @RequestBody FavoriteCreateRequest favoriteCreateRequest
    ) {
        favoriteService.createFavorite(menuId, memberId, favoriteCreateRequest);
        return ResponseEntity.ok(SuccessResponse.of(SuccessCode.POST_LIKES_MENU));
    }

}
