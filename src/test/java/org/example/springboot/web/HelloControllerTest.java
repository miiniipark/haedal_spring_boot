package org.example.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// 테스트를 위해 스프링에서 제공하는 기능들을 실행시키기 위한 어노테이션
// @SpringBootTest 와 달리 @Autowired 등 확인하여 필요한 기능만 가져온다
@RunWith(SpringRunner.class)
// 스프링의 여러 기능들 중 컨트롤러 기능만 불러와 가볍게 테스트하기 위해 사용
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {
    // 등록된 스프링 빈 객체들의 타입을 확인하여 자동으로 의존성을 주입
    @Autowired
    // 가상으로 웹 요청을 생성해주는 객체
    private MockMvc mvc;

    // JUnit 에서 메서드를 테스트로 인식한다
    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        // perform : MockMvc 의 동작 방식을 설정
        mvc.perform(get("/hello"))
                // 결과 검증
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                        get("/hello/dto")
                                // 쿼리 설정
                                .param("name", name)
                                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                // jsonPath : json 응답값을 필드별로 검증하는 메서드
                .andExpect(jsonPath("$.name", is(name)))
                // 필드의 값은 "$.필드명" 형태로 읽어온다
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
