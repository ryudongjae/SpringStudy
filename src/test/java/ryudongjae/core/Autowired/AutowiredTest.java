package ryudongjae.core.Autowired;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;
import ryudongjae.core.member.Member;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean{
        //호출안됨
        @Autowired(required = false)
        public void setNoBean1(Member member){
            System.out.println("setNoBean = " + member);
        }

        @Autowired  //null호출
        public void setNoBean2(@Nullable Member member){
            System.out.println("setNoBean2 = " +  member);
        }

        //Optional.empty 호출
        @Autowired
        public void setNoBean3(Optional<Member> member){
            System.out.println("setNoBean3 = " +  member);
        }
    }




}
