package org.example.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

// lombok 이용하여 getter 구현
@Getter
// final 키워드가 붙은 필드들을 포함한 생성자 구현
@RequiredArgsConstructor
public class HelloResponseDto {
    private final String name;
    private final int amount;
}
