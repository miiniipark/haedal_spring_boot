package org.example.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.springboot.domain.BaseTimeEntity;

import javax.persistence.*;

@Getter
// 기본 생성자 추가
@NoArgsConstructor
// 테이블과 링크되는 클래스
@Entity
public class Posts extends BaseTimeEntity {
    // Primary Key
    @Id
    // 키 값 자동 생성
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // 테이블의 컬럼을 나타냄. 기본적으로 적용되어 있으므로 옵션의 변경이 필요할 때 사용
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    // @column 기본적으로 적용
    private String author;

    // 빌터 패턴 사용
    // 생성자 상단에 선언 시 생성자에 포함된 필드들에 대하여 적용
    // 어떤 필드에 값을 입력하는지 명확하게 지정하여 실수를 방지할 수 있음
    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    // 객체의 값 변경 시, 별도의 쿼리 없이 트랜잭션이 끝나는 지점에서 변경분을 반영함
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
