package site.metacoding.serverproject.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import site.metacoding.serverproject.domain.Hospital;
import site.metacoding.serverproject.domain.HospitalRepository;

@RequiredArgsConstructor
@Controller
public class DownloadController {

    private final HospitalRepository hospitalRepository;

    @GetMapping("/")
    public String main() {
        return "/download";
    }

    @GetMapping("/download")
    public String download(Model model) {
        // 1. URI로 다운로드
        RestTemplate rt = new RestTemplate();
        Hospital[] hospital = rt.getForObject(
                "http://3.38.254.72:5000/api/hospital?sidoCdNm=부산&sgguCdNm=부산사하구",
                Hospital[].class);
        List<Hospital> hospitals = Arrays.asList(hospital);
        // 2. DB에 saveAll() + model에 담기
        hospitalRepository.saveAll(hospitals);
        model.addAttribute("hospitals", hospitals);
        // 3. 리턴
        return "/list";
    }
}
