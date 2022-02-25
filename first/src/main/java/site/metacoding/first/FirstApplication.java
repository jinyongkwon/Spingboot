package site.metacoding.first;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 이게 붙어있어야 성을 만들어줌.
public class FirstApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstApplication.class, args); // 성이 만들어짐!!!! // context를 리턴해줌 => 성 전체의 문맥을 return!!!!
	}

}
