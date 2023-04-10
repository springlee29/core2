package hello.core2.xml;

import hello.core2.member.MemberService;
import hello.core2.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class XmlConfigurationTest {

    @Test
    @DisplayName("xml 설정")
    void xmlConfiguration() {
        ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
        MemberService ms = ac.getBean("memberService", MemberService.class);
        assertThat(ms).isInstanceOf(MemberServiceImpl.class);
    }
}

