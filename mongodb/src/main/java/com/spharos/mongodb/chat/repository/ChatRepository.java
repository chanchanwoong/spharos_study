package com.spharos.mongodb.chat.repository;

import com.spharos.mongodb.chat.domain.Member;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatRepository extends MongoRepository<Member, String> {
    Optional<Member> findByEmail(String email);
}
