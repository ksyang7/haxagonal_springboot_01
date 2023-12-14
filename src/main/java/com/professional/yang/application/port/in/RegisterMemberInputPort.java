package com.professional.yang.application.port.in;

import com.professional.yang.application.port.out.MemberJoinOutputPort;
import com.professional.yang.application.usecases.JoinMemberUseCase;

public class RegisterMemberInputPort  implements JoinMemberUseCase {
	
	private final MemberJoinOutputPort memberJoinOutputPort;
	
	public RegisterMemberInputPort (MemberJoinOutputPort memberJoinOutputPort) {
		this.memberJoinOutputPort = memberJoinOutputPort;
	}

	@Override
	public void join(String userid, String pw) {
		memberJoinOutputPort.join(userid, pw);
		
	}

}
