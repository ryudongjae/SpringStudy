package ryudongjae.core;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
//권장하는 방법
// 설정 정보 클래스의 위치를 프로젝트 최상 단에 두는 것이다. 최근 스프링 부트도 이 방법을 기본으로 제공한다.
@Configuration
@ComponentScan(
        //컴포넌트 스캔을 사용하면 @Configuration 이 붙은 설정 정보도 자동으로 등록되기 때문에,
        // AppConfig, TestConfig 등 앞서 만들어두었던 설정 정보도 함께 등록되고,
        // 실행되어 버린다. 그래서 excludeFilters 를 이용해서 설정정보는 컴포넌트 스캔 대상에서 제외했다.
        basePackages = "ryudongjae.core", // 탐색할 패키지 시작위치를 지정한다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
}
