package org.example.springboot.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {
    @Test
    public void 롬복_기능_테스트() {
        String name = "test";
        int amount = 1000;

        HelloResponseDto dto = new HelloResponseDto(name, amount);

        // assertj 라이브러리의 검증 기능을 위한 객체를 반환하는 메서드
        assertThat(dto.getName()).isEqualTo(name);
        // isEqualTo 에서 전달받은 값과 비교
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
