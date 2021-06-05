package ryudongjae.core.member;

public interface MemberRepository {
    //가입 후 저장
    void save(Member member);
    //저장된 아이디 찾기
    Member findById(Long memberId);
}
