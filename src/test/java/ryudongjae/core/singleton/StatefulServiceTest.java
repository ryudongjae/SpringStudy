package ryudongjae.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
       ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);

        //ThreadA: A사용자 10000원 주문
       int APrice = statefulService1.order("A",10000);

        //ThreadB: B사용자 20000원 주문
        int BPrice = statefulService2.order("B",20000);

        System.out.println("APrice = " + APrice);

        //ThreadA: A사용자 주문금액조회
       // int price = statefulService1.getPrice();

        //System.out.println("price = "+ price);

        //Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);


    }

    static class TestConfig{

        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}
