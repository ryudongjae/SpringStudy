package ryudongjae.core.order;

import org.junit.jupiter.api.Test;
import ryudongjae.core.discount.RateDiscountPolicy;
import ryudongjae.core.member.Grade;
import ryudongjae.core.member.Member;
import ryudongjae.core.member.MemoryMemberRepository;

import static org.assertj.core.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void createOrderT(){
        MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();
        memoryMemberRepository.save(new Member(1L,"BB", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(new MemoryMemberRepository(),new RateDiscountPolicy());
        Order order = orderService.createOrder(1L, "A", 10000);

        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}