package sopt.twosome.service.Menu;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import sopt.twosome.domain.Menu;
import sopt.twosome.exception.ErrorCode;
import sopt.twosome.exception.InvalidArgsException;
import sopt.twosome.repository.MenuRepository;

@Component
@RequiredArgsConstructor
public class MenuRetriever {
    private final MenuRepository menuRepository;

    public Menu findMenuById(final long menuId) {
        return menuRepository.findById(menuId)
                .orElseThrow(() -> new InvalidArgsException(ErrorCode.NOT_EXISTS_MENU_WITH_ID));
    }
}
