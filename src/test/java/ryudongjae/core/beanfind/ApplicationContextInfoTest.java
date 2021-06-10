package ryudongjae.core.beanfind;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ryudongjae.core.AppConfig;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) { //beandefinition은 빈에 대한 정보들이다.
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("beanDefinitionName = " + beanDefinitionName + " object =" +bean);
        }
    }
    @Test
    @DisplayName("애플리케이션 빈 출력하")
    void findApplicationBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
            //ac.getBeanDefinitionNames() : 스프링에 등록된 모든 빈 이름을 조회한다.

            //Role ROLE_APPLICATION:직접 등록한 어플리케이션 빈
            //Role ROLE_INFRASTRUCTURE:스프링 내부에서 사용하는 빈

            if(beanDefinition.getRole() == BeanDefinition.ROLE_INFRASTRUCTURE){
                Object bean = ac.getBean(beanDefinitionName);
                //ac.getBean() : 빈 이름으로 빈 객체(인스턴스)를 조회한다.
                System.out.println("beanDefinitionName = " + beanDefinitionName +" object"+ bean);
            }

        }
    }
}
