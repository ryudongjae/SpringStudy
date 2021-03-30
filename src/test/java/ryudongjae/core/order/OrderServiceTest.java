package ryudongjae.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ryudongjae.core.AppConfig;
import ryudongjae.core.member.Grade;
import ryudongjae.core.member.Member;
import ryudongjae.core.member.MemberService;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void BeforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder(){
        Member member1 = new Member(1L,"memberA", Grade.VIP);
        Member member2 = new Member(2L,"memberB", Grade.BASIC);
        Member member3 = new Member(3L,"memberC", Grade.GOLD);
        memberService.join(member1);
        memberService.join(member2);
        memberService.join(member3);

        Order order1 = orderService.createOrder(1L, "itemA", 10000);
        Order order2 = orderService.createOrder(2L, "itemB", 5000);
        Order order3 = orderService.createOrder(3L, "itemC", 7000);
        Assertions.assertThat(order1.getDiscountPrice()).isEqualTo(700);
        Assertions.assertThat(order2.getDiscountPrice()).isEqualTo(0);
        Assertions.assertThat(order3.getDiscountPrice()).isEqualTo(350);
        Assertions.assertThat(order1.calcPrice()).isEqualTo(9300);
        Assertions.assertThat(order2.calcPrice()).isEqualTo(5000);
        Assertions.assertThat(order3.calcPrice()).isEqualTo(6650);
        Assertions.assertThat(order1.getItemName()).isEqualTo("itemA");
        Assertions.assertThat(order2.getItemName()).isEqualTo("itemB");


    }

}