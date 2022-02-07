package com.rootnode.devtree.db.repository;

import com.rootnode.devtree.db.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 유저 모델 관련 디비 쿼리 생성을 위한 JPA Query Method 인터페이스 정의.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // 아래와 같이, Query Method 인터페이스(반환값, 메소드명, 인자) 정의를 하면 자동으로 Query Method 구현됨.
    //
//    @Query(value = "select u from User u where u.userId = :user_id")
    Optional<User> findByUserId(String user_id);
    Optional<User> findByUserSeq(Long user_seq);

    List<User> findAll();
}