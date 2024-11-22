package sopt.twosome.service.Favorite;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import sopt.twosome.repository.FavoriteRepository;

@Component
@RequiredArgsConstructor
public class FavoriteRetriever {
    private final FavoriteRepository favoriteRepository;


}
