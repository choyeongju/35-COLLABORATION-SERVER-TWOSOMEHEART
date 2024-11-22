package sopt.twosome.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.twosome.domain.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
