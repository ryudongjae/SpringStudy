package ryudongjae.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long,Member> store  = new HashMap<>();

    @Override //가입후 메모리에 저장
    public void save(Member member) {

        store.put(member.getId(),member);
    }

    @Override //가입후 회원 조회
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
