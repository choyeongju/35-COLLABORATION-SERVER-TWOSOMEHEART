package sopt.twosome.service.Favorite;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import sopt.twosome.domain.Favorite;
import sopt.twosome.domain.Member;
import sopt.twosome.domain.Menu;
import sopt.twosome.dto.request.FavoriteCreateRequest;
import sopt.twosome.repository.MemberRepository;
import sopt.twosome.repository.MenuRepository;
import sopt.twosome.service.Member.MemberRetriever;
import sopt.twosome.service.Menu.MenuRetriever;

@Component
@RequiredArgsConstructor
public class FavoriteService {
    private final FavoriteSaver favoriteSaver;
    private final MemberRetriever memberRetriever;
    private final MenuRetriever menuRetriever;

    //메뉴 즐겨찾기(저장) 기능
    public Favorite createFavorite(final long menuId, final long memberId, final FavoriteCreateRequest favoriteCreateRequest) {

        Menu menu = menuRetriever.findMenuById(menuId);
        Member member = memberRetriever.findMemberById(memberId);

        // personal이 true인 경우 할인
        Long adjustedPrice = favoriteCreateRequest.personal()
                ? favoriteCreateRequest.price() - 300
                : favoriteCreateRequest.price();

        Favorite favoriteItem = Favorite.builder()
                .member(member)
                .menu(menu)
                .name(favoriteCreateRequest.name())
                .price(adjustedPrice)
                .temperature(favoriteCreateRequest.temperature())
                .size(favoriteCreateRequest.size())
                .coffeeBean(favoriteCreateRequest.coffeeBean())
                .togo(favoriteCreateRequest.togo())
                .personal(favoriteCreateRequest.personal())
                .imageUrl(menu.getImageUrl())
                .build();

        return favoriteSaver.save(favoriteItem);
    }


}
