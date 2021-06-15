package ryudongjae.core.Autowired;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ryudongjae.core.AutoAppConfig;
import ryudongjae.core.discount.DiscountPolicy;
import ryudongjae.core.member.Grade;
import ryudongjae.core.member.Member;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class AllBeanTest {
    @Test
    void findBeanAll(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class,DiscountService.class);

        DiscountService discountService = ac.getBean(DiscountService.class);
        Member member = new Member(1L, "userA", Grade.VIP);
        int discountPrice = discountService.discount(member,10000,"fixDiscountPolicy");

        assertThat(discountService).isInstanceOf(DiscountService.class);
        assertThat(discountPrice).isEqualTo(1000);

        int rateDiscountPolicy = discountService.discount(member,20000,"rateDiscountPolicy");

        assertThat(discountService).isInstanceOf(DiscountService.class);
        assertThat(rateDiscountPolicy).isEqualTo(1400);
    }
    static class DiscountService{
        private final Map<String, DiscountPolicy>discountPolicyMap;
        private final List<DiscountPolicy>discountPolicies;

        @Autowired
        public DiscountService(Map<String, DiscountPolicy> discountPolicyMap, List<DiscountPolicy> discountPolicies) {
            this.discountPolicyMap = discountPolicyMap;
            this.discountPolicies = discountPolicies;
            System.out.println("discountPolicyMap = " + discountPolicyMap);
            System.out.println("discountPolicies = " + discountPolicies);
        }

        public int discount(Member member, int price, String discountCode) {
            DiscountPolicy discountPolicy = discountPolicyMap.get(discountCode);


            return discountPolicy.discount(member,price);
        }
    }
}
