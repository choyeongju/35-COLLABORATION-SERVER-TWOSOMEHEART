package sopt.twosome.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@Table(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 멤버가 삭제되면 해당 멤버의 즐겨찾기 목록도 삭제되어야 함
    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<Favorite> favorites;
}
