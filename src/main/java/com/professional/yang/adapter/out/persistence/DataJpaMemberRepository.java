package com.professional.yang.adapter.out.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.professional.yang.domain.Member;

public interface DataJpaMemberRepository extends JpaRepository<Member, Long> {

	Optional<Member> findByUserid(String userId);
}
