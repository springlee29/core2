package hello.core2.order;

import hello.core2.AppConfig;
import hello.core2.discount.DiscountPolicy;
import hello.core2.discount.FixDiscountPolicy;
import hello.core2.member.Grade;
import hello.core2.member.Member;
import hello.core2.member.MemberService;
import hello.core2.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService;

    OrderService orderService;

    @BeforeEach
    void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }
    @Test
    void createOrder() {
        Member member = new Member(1L, "member1", Grade.VIP);
        memberService.join(member);
        Member member1 = memberService.findMember(1L);

        Order order1 = orderService.createOrder(member1.getId(),"itemTest",10000);
        System.out.println("order : " + order1);
        Assertions.assertThat(order1.getDiscountPrice()).isEqualTo(1000);
    }
}
