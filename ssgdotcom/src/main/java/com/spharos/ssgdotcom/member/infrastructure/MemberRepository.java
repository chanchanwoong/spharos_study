package com.spharos.ssgdotcom.member.infrastructure;

import com.spharos.ssgdotcom.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.*;
import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    // 기존 제공 CRUD 말고 추가 생성을 원할 시, 네이티브 쿼리(JPQL?)를 사용(@Query)
//    @Query(value = "select m from Member m where m.email = ~~~~~~")
//    Member findByEmailInName(String email, String name);

    // 여러 개를 찾을 때는 All 단어를 붙히고 ArrayList 타입으로 반환한다.
    ArrayList<Member> findAllByGender(Short gender);
}
