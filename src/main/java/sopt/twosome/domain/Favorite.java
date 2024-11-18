package sopt.twosome.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id", nullable = false)
    private Menu menu;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Long price;

    @Column(name = "temperature", nullable = false)
    private String temperature;

    @Column(name = "size", nullable = false)
    private String size;

    @Column(name = "coffee_bean", nullable = false)
    private String coffeeBean;

    @Column(name = "togo", nullable = false)
    private String togo;

    @Column(name = "personal")
    private Boolean personal;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;
}
