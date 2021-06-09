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

//애플리케이션의 전체 동작 방식을 구성하기 위해,구성 객체를 생성하고 연결하는 책임을 가지는 별도의 설정 클래스
@Configuration //appconfig를 구성정보로 사용한다 .@Bean이라 적힌 메서드를 모두 호출하고 반환된 객체를 스프링 컨테이너에 등록.
public class AppConfig {
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemoryMemberRepository memberRepository() {

        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService(){

        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
