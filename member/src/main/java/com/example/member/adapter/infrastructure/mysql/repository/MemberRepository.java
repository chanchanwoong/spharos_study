package com.example.member.adapter.infrastructure.mysql.repository;

import com.example.member.adapter.infrastructure.mysql.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
}
