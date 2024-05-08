package com.spharos.mongodb.chat.repository;

import com.spharos.mongodb.chat.domain.Member;
import java.util.Optional;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MemberRepository extends ReactiveMongoRepository<Member, String> {
    Optional<Member> findByEmail(String email);
}
