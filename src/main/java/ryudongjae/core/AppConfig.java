package ryudongjae.core;

import ryudongjae.core.discount.FixDiscountPolicy;
import ryudongjae.core.discount.RateDiscountPolicy;
import ryudongjae.core.member.MemberService;
import ryudongjae.core.member.MemberServiceImpl;
import ryudongjae.core.member.MemoryMemberRepository;
import ryudongjae.core.order.OrderService;
import ryudongjae.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(),new RateDiscountPolicy());
    }
}
