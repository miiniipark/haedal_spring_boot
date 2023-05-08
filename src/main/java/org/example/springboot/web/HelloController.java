package org.example.springboot.web;

import org.example.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// Controller : 요청받은 URL 에 대한 처리 방식을 정의해둔 것
// RestController : REST API 로 동작함 (웹 페이지 X, 데이터 반환)
@RestController
public class HelloController {
    // "/hello" URL 에 GET 메소드로 요청을 보냈을 경우에 대한 응답
    @GetMapping("/hello")
    // Response Body 에 문자열 hello 를 담아 반환 (RestController 이므로)
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    // 쿼리스트링 설정 ?name="전달받은 문자열"&amount="전달받은 문자열"
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}
