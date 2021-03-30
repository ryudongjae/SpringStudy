package ryudongjae.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ryudongjae.core.AppConfig;

public class MemberServiceTest {
    MemberService memberService;

    @BeforeEach //테스트 실행전 실행
    public void BeforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService =appConfig.memberService();
    }

    @Test
    void join(){



        //given
        Member member1 = new Member(1L,"memberA",Grade.VIP);
        Member member2 = new Member(2L,"memberB",Grade.BASIC);
        //when
        memberService.join(member2);
        Member findByMember = memberService.findMember(2L);

        //then

        Assertions.assertThat(member2).isEqualTo(findByMember); //join한 멤버와 findByMember의 멤버가 같은지

    }
    @Test
    void findById(){

    }
}