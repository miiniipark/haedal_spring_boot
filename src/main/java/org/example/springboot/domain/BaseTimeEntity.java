package org.example.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
// Entity 들이 이 클래스를 상속받아 필드를 포함하도록 함
@MappedSuperclass
// 데이터 자동 입력 기능 추가
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {
    // Entity 생성 시 자동으로 값 설정
    @CreatedDate
    private LocalDateTime createdDate;

    // Entity 수정 시 자동으로 값 설정
    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
