package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }


    // API 방식
    @GetMapping("hello-string")
    @ResponseBody // http에서 response body에 직접 내용을 넣어주겠다.
    public String helloString(@RequestParam(value = "name") String name) {
        return "hello " + name; // ex "hello spring"
    }

    @GetMapping("hello-api")
    @ResponseBody 
    public Hello helloApi(@RequestParam(value = "name") String name) {
        Hello hello = new Hello();
        hello.setName(name);

        // @ResponseBody로 객체를 반환하면 json 으로 변환해줌.(기본)
        return hello; // json 방식으로 내려줌. key-value 으로 이루어진 형식
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
