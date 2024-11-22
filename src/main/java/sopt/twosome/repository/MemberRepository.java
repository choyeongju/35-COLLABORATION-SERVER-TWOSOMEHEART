package sopt.twosome.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.twosome.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
