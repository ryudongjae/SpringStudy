package ryudongjae.core.discount;

import org.springframework.stereotype.Component;
import ryudongjae.core.annotation.MainDiscountPolicy;
import ryudongjae.core.member.Grade;
import ryudongjae.core.member.Member;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercentVip = 7;
    private int discountPercentGold = 5;


    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return price * discountPercentVip / 100;
        }else if(member.getGrade() == Grade.GOLD){
            return price * discountPercentGold /100;
        }else{
            return 0;
        }
    }
}
