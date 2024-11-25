package sopt.twosome.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sopt.twosome.enums.CoffeeBean;
import sopt.twosome.enums.Size;
import sopt.twosome.enums.Temperature;
import sopt.twosome.enums.Togo;

@Entity
@Getter
@Table(name = "favorite")
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
    private int price;

    @Column(name = "temperature", nullable = false)
    @Enumerated(EnumType.STRING)
    private Temperature temperature;

    @Column(name = "size", nullable = false)
    @Enumerated(EnumType.STRING)
    private Size size;

    @Column(name = "coffee_bean", nullable = false)
    @Enumerated(EnumType.STRING)
    private CoffeeBean coffeeBean;

    @Column(name = "togo", nullable = false)
    @Enumerated(EnumType.STRING)
    private Togo togo;

    @Column(name = "personal")
    private Boolean personal;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Builder
    public Favorite(long id, Member member, Menu menu, String name, int price, Temperature temperature, Size size, CoffeeBean coffeeBean, Togo togo, Boolean personal, String imageUrl) {
        this.id = id;
        this.member = member;
        this.menu = menu;
        this.name = name;
        this.price = price;
        this.temperature = temperature;
        this.size = size;
        this.coffeeBean = coffeeBean;
        this.togo = togo;
        this.personal = personal;
        this.imageUrl = imageUrl;
    }
}
