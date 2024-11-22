package sopt.twosome.service.Favorite;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import sopt.twosome.domain.Favorite;
import sopt.twosome.repository.FavoriteRepository;

@Component
@RequiredArgsConstructor
public class FavoriteSaver {
    private final FavoriteRepository favoriteRepository;

    public Favorite save(final Favorite favorite) {
        return favoriteRepository.save(favorite);
    }
}
