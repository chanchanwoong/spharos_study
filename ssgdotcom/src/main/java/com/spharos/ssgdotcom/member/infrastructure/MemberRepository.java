package com.spharos.ssgdotcom.member.infrastructure;

import com.spharos.ssgdotcom.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
public interface MemberRepository extends JpaRepository<Member, Long> {

}
