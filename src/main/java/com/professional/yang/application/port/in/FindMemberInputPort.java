package com.professional.yang.application.port.in;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.professional.yang.application.port.out.MemberFindOutputPort;
import com.professional.yang.application.usecases.FindOneMemberUseCase;
import com.professional.yang.domain.Member;

@Service
public class FindMemberInputPort implements FindOneMemberUseCase{
	private final MemberFindOutputPort memberFindOutputPort;
	
	public FindMemberInputPort(MemberFindOutputPort memberFindOutputPort) {
		this.memberFindOutputPort = memberFindOutputPort;
	}

	@Override
	public Optional<Member> findOne(String userId) {
		return memberFindOutputPort.findOne(userId);
	}
	
	
}
