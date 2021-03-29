package ryudongjae.core.discount;

import ryudongjae.core.member.Member;

public interface DiscountPolicy {
    /*
    @return 할인 대상금액
     */

    int discount(Member member,int price);
}
