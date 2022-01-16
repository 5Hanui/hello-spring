package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 직접 스프링 빈 등록하기
@Configuration
public class SpringConfig {

    // 기동할 때 MemberService와 MemberRepository를 스프링빈에 등록하고
    // 스프링빈에 등록되어있는 MemberRepository를 MemberService에 주입해준다

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }


}
