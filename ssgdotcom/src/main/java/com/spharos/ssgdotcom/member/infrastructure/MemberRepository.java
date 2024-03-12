package com.spharos.ssgdotcom.member.infrastructure;

import com.spharos.ssgdotcom.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.*;
import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long>{
    Optional<Member> findByUuid(String uuid);
    Optional<Member> findByLoginId(String loginId);
}