package site.metacoding.second.web;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    // SELECT * FROM post WHERE id = ?
    // 구체적으로 뭘 달라고 요청!! - body X
    // "/post?id=1" == "/post/1"
    @GetMapping("/post/{id}")
    public String test1(@PathVariable int id) {
        return "주세요 id : " + id;
    }

    // SELECT * FROM post WHERE title = ?
    // http://localhost:8000/post?title=?
    @GetMapping("/post")
    public String search(String title) {
        // String title = request.getParameter("title"); 이부분을 parameter에 선언하는것만으로 DS가
        // 알아서 해줌
        return "주세요 title : " + title;
    }

    // http://localhost:8000/post
    // body : title=제목1&content=내용1
    // header : Content-Type : application/x-www-form-urlencoded 이렇게 알려줘야함
    // request.getParameter() 메서드가 스프링 기본 파싱 전략 => 즉 x-www-form-urlencoded타입만 파싱가능
    // (.json, .xml등 다른 중간언어는 파싱 x)
    // 뭘 줘야 함 - body O
    @PostMapping("/post")
    public String test2(String title, String content) { // 받았으니 DB에 INSERT하면 끝!!!!
        return "줄께요 : title : " + title + ", content : " + content;
    }

    // UPDATE post SET title = ?, content = ? WHERE id =?
    // => WHERE절에 들어가는 조건은 모두 주소로 보내주어야한다 규칙임!!
    // title, content (primary key : id) => PK로 수정!!
    // id를 수정하는게 아니라 id를 참고해서 수정하므로 주소에 id를 넣어줌
    // 뭘 줘야 함 - Body O
    // API 문서를 만들어서 줘야함 ex)공공데이터 포털에 API 문서
    @PutMapping("/post/{id}")
    public String test3(String title, String content, @PathVariable int id) {
        return "수정해주세요 : title : " + title + ", content : " + content + ", id : " + id;
    }

    // http://localhost:8000/post?title=제목1
    // DELETE form post WHERE title = ?
    // http://localhost:8000/post/1
    // DELETE FROM post WHERE id = ?
    // 구체적으로 삭제해주세요 - body X
    // 주소에다가 요청!!
    @DeleteMapping("/post/{id}")
    public String test4(String title, @PathVariable int id) {
        return "삭제해주세요 : title : " + title + ", id : " + id;
    }
}
