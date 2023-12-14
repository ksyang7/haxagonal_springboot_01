package com.professional.yang.adapter.in.security;

import java.util.Optional;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.professional.yang.application.usecases.FindOneMemberUseCase;
import com.professional.yang.domain.Member;

public class MyUserDetailService implements UserDetailsService{
	private final FindOneMemberUseCase findOneMemberCase;

	public MyUserDetailService(FindOneMemberUseCase findOneMemberCase) {
		this.findOneMemberCase = findOneMemberCase;
	}
	
	@Override
	public UserDetails loadUserByUsername(String insertedUserId) throws UsernameNotFoundException {
		Optional<Member> findOne = findOneMemberCase.findOne(insertedUserId);
		Member member = findOne.orElseThrow(() -> new UsernameNotFoundException("존재하지 않는 회원 입니다."));
		
		return User.builder()
						.username(member.getUserid())
						.password(member.getPw())
						.roles(member.getRoles())
						.build();
	}
}
