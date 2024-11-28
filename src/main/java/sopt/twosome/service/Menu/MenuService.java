package sopt.twosome.service.Menu;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.twosome.domain.Member;
import sopt.twosome.domain.Menu;
import sopt.twosome.dto.response.TaskDetailDto;
import sopt.twosome.service.Member.MemberRetriever;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MenuService {

    private final MenuRetriever menuRetriever;
    private final MemberRetriever memberRetriever;

    public TaskDetailDto getMenuDetails(final long memberId, final long menuId) {

        Member member = memberRetriever.findMemberById(memberId);
        Menu menu = menuRetriever.findMenuById(menuId);

        return TaskDetailDto.builder()
                .id(menu.getId())
                .name(menu.getName())
                .status(menu.getStatus())
                .description(menu.getDescription())
                .price(menu.getPrice())
                .caution(menu.getCaution())
                .nutrition(menu.getNutrition())
                .allergy(menu.getAllergy())
                .image_url(menu.getImageUrl())
                .build();
    }
}
