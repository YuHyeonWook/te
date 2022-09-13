package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService ;

    @BeforeEach // 각 테스트 실행전에 BeforeEach가 무조건 실행되는것
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        //given  vip를 만들었을때
        Member member = new Member (1L, "memberA", Grade.VIP);
        //when   memberService에 join을  했을때
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        //then    이렇게 된다.
        Assertions.assertThat(member).isEqualTo(findMember);
    }

}
