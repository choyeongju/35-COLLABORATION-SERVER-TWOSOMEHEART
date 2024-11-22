package sopt.twosome.dto.response;

import sopt.twosome.enums.CoffeeBean;
import sopt.twosome.enums.Size;
import sopt.twosome.enums.Temperature;
import sopt.twosome.enums.Togo;

import java.util.List;

public record FavoriteListResponse(
        List<FavoriteResponse> favoriteList
) {
    public record FavoriteResponse(
            long id,
            String name,
            int price,
            String imageUrl,
            int temperature,
            int size,
            int coffeeBean,
            int togo,
            boolean personal
    ) {
        public static FavoriteResponse of(final Long id, final String name, final int price, final String imageUrl, final Temperature temperature, final Size size, final CoffeeBean coffeeBean, final Togo togo, final boolean personal) {
            return new FavoriteResponse(id, name, price, imageUrl, temperature.getIndex(), size.getIndex(), coffeeBean.getIndex(), togo.getIndex(), personal);
        }

    }

    public static FavoriteListResponse of(final List<FavoriteResponse> favoriteList) {
        return new FavoriteListResponse(favoriteList);
    }
}
