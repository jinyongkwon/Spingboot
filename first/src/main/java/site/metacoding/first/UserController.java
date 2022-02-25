package site.metacoding.first;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Data를 리턴하는 컨트롤러(PrintWriter로 리턴함)
@RestController
public class UserController {

    public UserController() {
        System.out.println("UserController 생성자 실행됨");
    }

    @GetMapping("/home")
    public void home() {
        System.out.println("home~~~~~~~~~~~~~~~~~~~~~~");
    }

    @GetMapping("/bye")
    public void bye() {
        System.out.println("bye~~~~~~~~~~~~~~~~~~~~~~");
    }

    @GetMapping("/data")
    public String data() {
        return "<h1>data</h1>"; // PrintWriter -> write -> flush
    }
}
