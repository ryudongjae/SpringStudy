package ryudongjae.core.member;

public interface MemberService {
    //가입
    void join(Member member);
    //회원 조회
    Member findMember(Long MemberId);
}
