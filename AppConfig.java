package ryudongjae.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ryudongjae.core.discount.DiscountPolicy;
import ryudongjae.core.discount.RateDiscountPolicy;
import ryudongjae.core.member.MemberService;
import ryudongjae.core.member.MemberServiceImpl;
import ryudongjae.core.member.MemoryMemberRepository;
import ryudongjae.core.order.OrderService;
import ryudongjae.core.order.OrderServiceImpl;

@Configuration
public class AppConfig {

    @Bean //스프링 컨테이너 등록
    public MemberService memberService(){

        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemoryMemberRepository memberRepository() {

        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService(){

        return new OrderServiceImpl(memberRepository(),new RateDiscountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy(){

        return new RateDiscountPolicy();
    }
}
