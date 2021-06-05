package ryudongjae.core.discount;

import ryudongjae.core.member.Grade;
import ryudongjae.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{
    private int discountFixAmountVip = 1000;//vip등급은 1000원 할인.
    private int discountFixAmountGold = 500; //GOLD등급은 500원 할

    @Override //할인정책(등급별 할인)
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return discountFixAmountVip;
        }else if (member.getGrade() == Grade.GOLD){
            return discountFixAmountGold;
        }else{
            return 0;
        }
    }
}
