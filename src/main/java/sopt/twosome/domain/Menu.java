package sopt.twosome.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sopt.twosome.enums.Status;

@Entity
@Getter
@Table(name = "menu")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "caution")
    private String caution;

    @Column(name = "nutrition", nullable = false)
    private String nutrition;

    @Column(name = "allergy")
    private String allergy;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;
}
