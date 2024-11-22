package sopt.twosome.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.twosome.domain.Favorite;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

}
