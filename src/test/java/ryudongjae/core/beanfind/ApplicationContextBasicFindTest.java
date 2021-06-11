package ryudongjae.core.beanfind;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ryudongjae.core.AppConfig;
import ryudongjae.core.member.MemberService;
import ryudongjae.core.member.MemberServiceImpl;
import ryudongjae.core.order.OrderServiceImpl;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("bean 이름 으로 조회")
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    @DisplayName("이름 없이 타입만으로 조회")
    void findBeanByType() {
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class); // 인스턴스 확인
    }


    @Test
    @DisplayName("구체타입으로 조회")
    void findBeanByName2() {
        OrderServiceImpl orderService = ac.getBean("orderService",OrderServiceImpl.class);
        Assertions.assertThat(orderService).isInstanceOf(OrderServiceImpl.class);
        }

    @Test
    @DisplayName("bean 이름으로 조회 X")
    void findBeanByNameX() {
        //ac.getBean("XXXX",MemberService.class);
        assertThrows(NoSuchBeanDefinitionException.class,
                ()->ac.getBean("XXXX",MemberService.class));
    }

}