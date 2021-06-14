package ryudongjae.core.order;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ryudongjae.core.discount.DiscountPolicy;
import ryudongjae.core.member.Member;
import ryudongjae.core.member.MemberRepository;

@Component
@RequiredArgsConstructor //final 들어간 필드 생성자 만들어 줌
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository; //회원 조회
    private final DiscountPolicy discountPolicy;  //고정할인

//   @Autowired // 자동의존관계 주입
//    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }

//    @Autowired
//    public void init(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
