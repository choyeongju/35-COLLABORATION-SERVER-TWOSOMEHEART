package sopt.twosome.service.Member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import sopt.twosome.domain.Member;
import sopt.twosome.exception.ErrorCode;
import sopt.twosome.exception.InvalidArgsException;
import sopt.twosome.repository.MemberRepository;

@Component
@RequiredArgsConstructor
public class MemberRetriever {
    private final MemberRepository memberRepository;

    public Member findMemberById(final long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new InvalidArgsException(ErrorCode.NOT_EXISTS_MEMBER_WITH_ID));
    }
}
