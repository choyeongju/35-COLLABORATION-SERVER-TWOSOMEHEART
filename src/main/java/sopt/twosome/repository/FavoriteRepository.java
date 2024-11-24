package sopt.twosome.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sopt.twosome.domain.Favorite;
import sopt.twosome.enums.CoffeeBean;
import sopt.twosome.enums.Size;
import sopt.twosome.enums.Temperature;
import sopt.twosome.enums.Togo;

import java.util.List;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

    // 존재 여부 확인
    @Query("SELECT COUNT(f) > 0 FROM Favorite f WHERE f.member.id = :memberId")
    boolean existsByMemberId(@Param("memberId") long memberId);

    // 존재하는 즐겨찾기 id만 필터링
    @Query("SELECT f.id FROM Favorite f WHERE f.member.id = :memberId AND f.id IN :favoriteIds")
    List<Long> findExistingFavoriteIds(@Param("memberId") long memberId, @Param("favoriteIds") List<Long> favoriteIds);

    /*
    삭제
     */
    @Modifying
    @Query("DELETE FROM Favorite f WHERE f.member.id = :memberId")
    void deleteByMemberId(@Param("memberId") long memberId);

    @Modifying
    @Query("DELETE FROM Favorite f WHERE f.member.id = :memberId AND f.id IN :favoriteIds")
    void deleteByMemberIdAndIds(@Param("memberId") long memberId, @Param("favoriteIds") List<Long> favoriteIds);

    List<Favorite> findAllByMemberId(long memberId);
    boolean existsByMemberIdAndMenuIdAndTemperatureAndSizeAndCoffeeBeanAndTogo(
            long memberId,
            long menuId,
            Temperature temperature,
            Size size,
            CoffeeBean coffeeBean,
            Togo togo
    );
}
