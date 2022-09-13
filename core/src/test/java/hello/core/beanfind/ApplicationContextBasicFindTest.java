package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac  = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로  조회하기 ")
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        // 검증하기
        //memberService 가 MemberServiceImpl의 인스턴스이면 성공이다.
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 타입으로  조회하기 ")
    void findBeanByType() {
        MemberService memberService = ac.getBean(MemberService.class);
        // 검증하기
        //memberService 가 MemberServiceImpl의 인스턴스이면 성공이다.
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회하기 ")
    void findBeanByName2() {
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);

        // 검증하기
        //memberService 가 MemberServiceImpl의 인스턴스이면 성공이다.
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    
    @Test
    @DisplayName("빈 이름으로 조회 실패")
    void findBeanByNameX() {
//        ac.getBean("X", MemberService.class);
//        MemberService x = ac.getBean("X", MemberService.class);
        assertThrows(NoSuchBeanDefinitionException.class ,
                () -> ac.getBean("X", MemberService.class));
    }
}
