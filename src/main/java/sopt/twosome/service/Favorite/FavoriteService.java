package sopt.twosome.service.Favorite;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.twosome.domain.Favorite;
import sopt.twosome.domain.Member;
import sopt.twosome.domain.Menu;
import sopt.twosome.dto.request.FavoriteCreateRequest;
import sopt.twosome.dto.response.FavoriteListResponse;
import sopt.twosome.exception.DuplicateOptionException;
import sopt.twosome.exception.ErrorCode;
import sopt.twosome.repository.FavoriteRepository;
import sopt.twosome.service.Member.MemberRetriever;
import sopt.twosome.service.Menu.MenuRetriever;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FavoriteService {

    private final MemberRetriever memberRetriever;
    private final MenuRetriever menuRetriever;

    private final FavoriteSaver favoriteSaver;
    private final FavoriteRemover favoriteRemover;
    private final FavoriteRepository favoriteRepository;

    //메뉴 즐겨찾기(저장) 기능
    @Transactional
    public Favorite createFavorite(final long menuId, final long memberId, final FavoriteCreateRequest favoriteCreateRequest) {

        Menu menu = menuRetriever.findMenuById(menuId);
        Member member = memberRetriever.findMemberById(memberId);

        // personal이 true인 경우 할인
        int adjustedPrice = favoriteCreateRequest.personal()
                ? favoriteCreateRequest.price() - 300
                : favoriteCreateRequest.price();

        //즐겨찾기 메뉴 중복 확인
        boolean isDuplicate = favoriteRepository.existsByMemberIdAndMenuIdAndTemperatureAndSizeAndCoffeeBeanAndTogo(
                memberId,
                menuId,
                favoriteCreateRequest.temperature(),
                favoriteCreateRequest.size(),
                favoriteCreateRequest.coffeeBean(),
                favoriteCreateRequest.togo()
        );

        if (isDuplicate) {
            throw new DuplicateOptionException(ErrorCode.DUPLICATED_MENU_OPTION);
        }

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

        //favorite 존재하면 예외 처리

        return favoriteSaver.save(favoriteItem);
    }

    // 즐겨찾기 메뉴 삭제
    @Transactional
    public void removeFavorites(final long memberId, final String favoriteIds, final boolean all){
        Member member = memberRetriever.findMemberById(memberId);
        if(all){
            favoriteRemover.deleteByMemberId(member.getId());
        } else if (favoriteIds != null && !favoriteIds.isEmpty()) {
            List<Long> favoriteIdList = Arrays.stream(favoriteIds.split(",")).map(Long::parseLong).toList();
            favoriteRemover.deleteByMemberIdAndIds(member.getId(), favoriteIdList);
        } else {
            throw new IllegalArgumentException("all 이나 favoriteIds 둘 중 하나는 반드시 포함되어야 합니다.");
        }
    }

    //즐겨찾기 리스트 조회 기능
    public FavoriteListResponse getListFavorites(final long memberId) {
        Member member = memberRetriever.findMemberById(memberId);
        List<Favorite> favoriteList = favoriteRepository.findAllByMemberId(memberId);
        List<FavoriteListResponse.FavoriteResponse> favoriteResponse = favoriteList.stream()
                .map(favorite -> FavoriteListResponse.FavoriteResponse.of(
                        favorite.getId(),
                        favorite.getName(),
                        favorite.getPrice(),
                        favorite.getImageUrl(),
                        favorite.getTemperature(),
                        favorite.getSize(),
                        favorite.getCoffeeBean(),
                        favorite.getTogo(),
                        favorite.getPersonal()
                ))
                .toList();

        return FavoriteListResponse.of(favoriteResponse);
    }
}
