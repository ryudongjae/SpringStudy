package ryudongjae.core.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ryudongjae.core.member.Grade;
import ryudongjae.core.member.Member;



class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 7프로 할인되어야한다")
    void vip_o(){
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        Assertions.assertThat(discount).isEqualTo(700);

    }
    @Test
    @DisplayName("VIP가 아니면 할인이 안되어야한다. ")
    void vip_x(){
        //given
        Member member = new Member(1L, "memberB", Grade.BASIC);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        Assertions.assertThat(discount).isEqualTo(0);
    }

    @Test
    @DisplayName("GOLD등급은 5프로 할인. ")
    void gold_o(){
        //given
        Member member = new Member(3L, "memberC", Grade.GOLD);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        Assertions.assertThat(discount).isEqualTo(500);
    }
    @Test
    @DisplayName("GOLD등급 아니면 5프로 할인X. ")
    void gold_x(){
        //given
        Member member = new Member(3L, "memberC", Grade.BASIC   );
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        Assertions.assertThat(discount).isEqualTo(0);
    }

}