package site.metacoding.first;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// 파일을 리턴함 
// RequestDispatcher dis = request.getRequestDispatcher("파일명"); 
// dis.forward(request, response);  => 내부적으로 돌기때문에 주소도 안바뀜!! 기억할것.
// 리턴하는 글자가 request로 쏙 들어감.
@Controller
public class PostController {

    @GetMapping("/writeForm")
    public String writeForm() {
        return "writeForm"; // 리턴해주는 파일의 위치는 무조건 templates에서 해줌. => templates에 있는 writeForm파일을 return
    }

    @GetMapping("/updateForm")
    public String updateForm() {
        return "updateForm";
    }
}
