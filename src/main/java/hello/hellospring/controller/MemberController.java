package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

// 컴포넌트 스캔방식으로 스프링빈 등록
@Controller // -> spring container 에 등록하여 관리한다
public class MemberController {

     /* DI
     1. 필드 주입방법 -> 비추
     @Autowired
     private MemberService memberService;
     
     2. setter 방법

     생성후 setter가 호출되어 주입됨.
     
     public하게 노출되어 중간에 잘못바꾼다면 문제가 일어날 수 있다.

     private MemberService memberService;

     @Autowired
     public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
      }

      3. 생성자 주입 방식이 제일 좋다
      의존관계가 실행중에 동적으로 변하는 경우는 없으므로 생성자 주입을 권장!!!

     
     */

    private final MemberService memberService;


    // controller를 등록할 때 생성자를 호출하여 스프링 컨테이너에서 memberService를 찾아서 연결해준다.
    @Autowired
    public MemberController(MemberService memberService) { // 의존관계를 주입해줌
        this.memberService = memberService;
    }
    /** 실행 --> Consider defining a bean of type 'hello.hellospring.service.MemberService' in your configuration. 에러문구
     public class MemberService 는 단순한 코드일뿐 @Service로 등록해준다
     */

    @GetMapping("/members/new")
    public String createForm() {

        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/"; // home화면으로 돌려보냄
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members); // 화면으로 넘김
        return "members/memberList";
    }

}
