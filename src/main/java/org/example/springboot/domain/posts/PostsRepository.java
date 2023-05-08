package org.example.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// DB 접근자
// Entity 클래스와 같은 디렉토리에 위치해야 함
// 데이터베이스에 상호작용하여 값을 Entity 클래스에 저장함
// <Entity, Primary Key>
public interface PostsRepository extends JpaRepository<Posts, Long> {
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
