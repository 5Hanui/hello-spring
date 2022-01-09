package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
// 컴포넌트 스캔방식으로 스프링빈 등록
@Controller // -> spring container 에 등록하여 관리한다
public class MemberController {

    private final MemberService memberService;


    // controller를 등록할 때 생성자를 호출하여 스프링 컨테이너에서 memberService를 찾아서 연결해준다.
    @Autowired
    public MemberController(MemberService memberService) { // 의존관계를 주입해줌
        this.memberService = memberService;
    }
    /** 실행 --> Consider defining a bean of type 'hello.hellospring.service.MemberService' in your configuration. 에러문구
     public class MemberService 는 단순한 코드일뿐 @Service로 등록해준다
     */
}
