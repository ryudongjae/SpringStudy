package ryudongjae.core.order;

import ryudongjae.core.discount.DiscountPolicy;
import ryudongjae.core.discount.FixDiscountPolicy;
import ryudongjae.core.member.Member;
import ryudongjae.core.member.MemberRepository;
import ryudongjae.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository(); //회원 조
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();  //고정할인

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId , itemName , itemPrice, discountPrice);
    }
}
