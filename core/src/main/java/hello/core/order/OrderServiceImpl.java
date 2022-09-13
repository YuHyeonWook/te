package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    // MemberRepository에서 회원찾기
     private final MemberRepository memberRepository;
     private final DiscountPolicy discountPolicy;

    // DiscountPolicy는 정액할인 정책
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    @Autowired
    private  DiscountPolicy rateDiscountPolicy;
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        // 1. memberRepository에서 회원id를 찾는다.
        Member member = memberRepository.findById(memberId);
        // 2. discountPolicy에 회원id을 전달한다.
        int discountPrice = discountPolicy.discount(member, itemPrice);

        // 최종 주문을 반환을 한다.
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도이다
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
