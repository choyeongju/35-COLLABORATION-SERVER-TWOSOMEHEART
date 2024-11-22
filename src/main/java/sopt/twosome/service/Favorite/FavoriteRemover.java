package sopt.twosome.service.Favorite;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import sopt.twosome.exception.ErrorCode;
import sopt.twosome.exception.NotFoundException;
import sopt.twosome.repository.FavoriteRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FavoriteRemover {

    private final FavoriteRepository favoriteRepository;

    public void deleteByMemberId(final long memberId) {
        boolean exists = favoriteRepository.existsByMemberId(memberId);
        if (!exists) {
            throw new NotFoundException(ErrorCode.NOT_FOUND_LIKES_MENU);
        }
        favoriteRepository.deleteByMemberId(memberId);
    }

    public void deleteByMemberIdAndIds(final long memberId, List<Long> favoriteIds) {
        List<Long> existingIds = favoriteRepository.findExistingFavoriteIds(memberId, favoriteIds);
        if (existingIds.size() != favoriteIds.size()) {
            throw new NotFoundException(ErrorCode.NOT_FOUND_LIKES_MENU);
        }
        favoriteRepository.deleteByMemberIdAndIds(memberId, favoriteIds);
    }
}