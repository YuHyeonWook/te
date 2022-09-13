package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements DiscountPolicy{

    private int discountDixAmount = 1000; // 천원 할인 하는 메서드

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return discountDixAmount; //vip이면 천원 할인함
        } else{
        return 0; //vip아니면 할인 없음

        }


    }
}
