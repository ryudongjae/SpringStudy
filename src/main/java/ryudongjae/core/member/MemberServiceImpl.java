package ryudongjae.core.member;


//구현체
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override //가입
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override   //회원조회
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
