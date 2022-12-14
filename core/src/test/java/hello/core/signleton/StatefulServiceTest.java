package hello.core.signleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.assertThat;


class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // ThreadA : A사용자가  10000원을 주문함
        statefulService1.order("userA", 10000);
        // ThreadA : B사용자가  20000원을 주문함
        statefulService2.order("userB", 20000);

        // ThreadA : 사용자A가 주문 금액을 조회함
        int price = statefulService1.getPrice();
        System.out.println("price = " + price);

//        Assertions.assertThat(statefulService1.getPrice()).isEqualTo();
        assertThat(statefulService1.getPrice()).isEqualTo(20000);


    }

    static class TestConfig {
        @Bean
        public  StatefulService statefulService() {
            return  new StatefulService();
        }
    }
}