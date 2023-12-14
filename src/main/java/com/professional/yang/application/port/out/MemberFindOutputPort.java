package com.professional.yang.application.port.out;

import java.util.Optional;

import com.professional.yang.domain.Member;

public interface MemberFindOutputPort {
	
	Optional<Member> findOne(String userId);
}
