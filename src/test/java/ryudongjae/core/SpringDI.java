package ryudongjae.core;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import ryudongjae.core.discount.DiscountPolicy;
import ryudongjae.core.member.MemberRepository;

public class SpringDI {
    /*의존관계 주입은 크게 4가지 방법
    * 생성자 주입
    * 불변, 필수 의존 관계에 사용
    * 생성자 호출 시점에 딱 한번만 호출되는 것이 보장된다.
    * 스프링 빈에 해당하는 경우 생성자가 하나만 있으면 @Autowired 생략가능
    *
    * */

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;
    @Autowired
    public SpringDI(MemberRepository memberRepository, DiscountPolicy
            discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    /*
    * 수정자 주입(Setter 주입)
    * setter라 불리는 필드의 값을 변경하는 수정자 메서드를 통해서 의존관계를 주입하는 방법이다.
    *선택, 변경 가능성이 있는 의존관계에 사용
    * 자바빈 프로퍼티 규약의 수정자 메서드 방식을 사용하는 방법이다.
    * */
    //@Autowired의 기본 동작은 주입할 대상이 없으면 오류가 발생한다. 주입할 대상이 없어도 동작하게 하려면 @Autowired(required = false) 로 지정하면 된다.

     /**   private MemberRepository memberRepository;
        private DiscountPolicy discountPolicy;
        @Autowired
        public void setMemberRepository(MemberRepository memberRepository) {
            this.memberRepository = memberRepository;
        }
        @Autowired
        public void setDiscountPolicy(DiscountPolicy discountPolicy) {
            this.discountPolicy = discountPolicy;
        }
        */
    /*
    * 필드 주입
    *외부에서 변경불가해서 테스트 힘듦
    * 애플리케이션의 실제 코드와 관계없는 테스트코드에 사용
    * 스프링 설정을 목적으로 하는 @Configuration같은 곳에서 사용
    *
    *    @Autowired
        private MemberRepository memberRepository;
        @Autowired
        private DiscountPolicy discountPolicy;
    * */



        /*
    *일반 메서드 주입
    *
    *한번에 여러 필드를 주입 받을 수 있다.
@Autowired
    public void init(MemberRepository memberRepository, DiscountPolicy
    discountPolicy) {
            this.memberRepository = memberRepository;
            this.discountPolicy = discountPolicy;
        }
    * */

    /** 생성자 주입을 선택해라!
    과거에는 수정자 주입과 필드 주입을 많이 사용했지만, 최근에는 스프링을 포함한 DI 프레임워크 대부분이
    생성자 주입을 권장한다. 그 이유는 다음과 같다.
    불변
    대부분의 의존관계 주입은 한번 일어나면 애플리케이션 종료시점까지 의존관계를 변경할 일이 없다. 오히려 대부분의 의존관계는 애플리케이션 종료 전까지 변하면 안된다.(불변해야 한다.)
    수정자 주입을 사용하면, setXxx 메서드를 public으로 열어두어야 한다.
    누군가 실수로 변경할 수 도 있고, 변경하면 안되는 메서드를 열어두는 것은 좋은 설계 방법이 아니다. 생성자 주입은 객체를 생성할 때 딱 1번만 호출되므로 이후에 호출되는 일이 없다. 따라서 불변하게 설계할 수 있다.

    */
}
