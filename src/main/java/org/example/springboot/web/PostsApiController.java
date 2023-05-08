package org.example.springboot.web;

import lombok.RequiredArgsConstructor;
import org.example.springboot.service.posts.PostsService;
import org.example.springboot.web.dto.PostsResponseDto;
import org.example.springboot.web.dto.PostsSaveRequestDto;
import org.example.springboot.web.dto.PostsUpdateRequestDto;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    // @RequestBody, Body 에 담긴 데이터를 객체로 변환하여 매핑된 필드에 담아 반환
    // @RequestBody 를 통해 받아온 객체를 데이터베이스에 저장
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    // RequestParam 는 쿼리스트링 형태, PathVariable 은 /{id} 의 형태
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }
}
