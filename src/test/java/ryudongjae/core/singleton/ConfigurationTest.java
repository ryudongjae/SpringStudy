package ryudongjae.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ryudongjae.core.AppConfig;
import ryudongjae.core.member.MemberRepository;
import ryudongjae.core.member.MemberServiceImpl;
import ryudongjae.core.member.MemoryMemberRepository;
import ryudongjae.core.order.OrderServiceImpl;

public class ConfigurationTest {

    @Test
    void configurationTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService",MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);


        //모두 같은 인스턴스를 참고하고 있다.
        System.out.println("memberService -> memberRepository= " + memberService.getMemberRepository());
        System.out.println("orderService -> memberRepository= " + orderService.getMemberRepository());
        System.out.println("memberRepository = " + memberRepository);


        Assertions.assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
        Assertions.assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
    }

    @Test
    void configurationDeep(){

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        //appConfig도 빈으로 등록된다.
        AppConfig appConfig = ac.getBean(AppConfig.class);

        System.out.println("appConfig = " + appConfig.getClass());

        /*
        *
        * 내가 만든 클래스가 아니라 스프링이 CGLIB라는 바이트코드 조작 라이브러리를
        * 사용해서 AppConfig 클래스 를 상속받은 임의의 다른 클래스를 만들고,
        *  그 다른 클래스를 스프링 빈으로 등록한 것이다!
        * */
    }
}
