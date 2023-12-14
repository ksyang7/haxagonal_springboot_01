package com.professional.yang.adapter.out.persistence;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.professional.yang.application.port.out.MemberFindOutputPort;
import com.professional.yang.application.port.out.MemberJoinOutputPort;
import com.professional.yang.domain.Member;

@Repository
public class MemberRepository implements MemberFindOutputPort, MemberJoinOutputPort {

	private final PasswordEncoder passwordEncoder;
	private final DataJpaMemberRepository repository;
	
	public MemberRepository(PasswordEncoder passwordEncoder, DataJpaMemberRepository repository) {
        this.passwordEncoder = passwordEncoder;
        this.repository = repository;
    }

    @Override
    public Optional<Member> findOne(String userId) {
        return repository.findByUserid(userId);
    }

    @Override
    public Long join(String userid, String pw) {
        Member member = Member.createUser(userid, pw, passwordEncoder);
        validateDuplicateMember(member);
        repository.save(member);

        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        repository.findByUserid(member.getUserid())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
}
