package ryudongjae.core;

import ryudongjae.core.member.Grade;
import ryudongjae.core.member.Member;
import ryudongjae.core.member.MemberService;
import ryudongjae.core.member.MemberServiceImpl;
import ryudongjae.core.order.Order;
import ryudongjae.core.order.OrderService;
import ryudongjae.core.order.OrderServiceImpl;



public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Member member1 = new Member(1L,"memberA", Grade.VIP);
        Member member2 = new Member(2L,"memberB", Grade.BASIC);
        memberService.join(member1);
        memberService.join(member2);

        Order orderA = orderService.createOrder(1L, "memberA", 10000);
        Order orderB = orderService.createOrder(2L, "memberB", 10000);

        System.out.println("orderA = " + orderA.calcPrice());
        System.out.println("orderB = " + orderB.calcPrice());


    }
}
