package site.metacoding.third;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // file을 return하는 Controller
public class PostController {

    @GetMapping("/post/writeForm")
    public String writeForm() {
        // /resources/templates/{리턴값}.mustache 뷰리졸버 설정
        return "post/writeForm"; // 파일경로 (ViewResolver 설정이 되어 있음 - mustache 라이브러리)
    }

    // Post 메서드로 요청 -> http://localhost:8000/post
    // title=제목1&content=내용1 -> x-www-form-urlencoded
    // 스프링 기본 파싱전략 -> x-www-form-urlencoded 만 파싱함
    @PostMapping("/post")
    public String write(String title, String content, Model model) {
        // 1. title과 content로 DB에 insert하기
        System.out.println("title : " + title);
        System.out.println("content : " + content);

        // 2. 글 목록페이지로 이동
        model.addAttribute("title", title);
        return "post/list"; // 응답
    }
}
