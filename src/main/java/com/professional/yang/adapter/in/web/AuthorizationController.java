package com.professional.yang.adapter.in.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.professional.yang.adapter.out.persistence.MemberJoinEntity;
import com.professional.yang.application.usecases.JoinMemberUseCase;

@RestController
@RequestMapping("/auth")
public class AuthorizationController {
	
	private final JoinMemberUseCase joinMemberUseCase;
	
	public AuthorizationController(JoinMemberUseCase joinMemberUseCase) {
		this.joinMemberUseCase = joinMemberUseCase;
	}
	
	@PostMapping("/join")
	public ResponseEntity<String> join(@RequestBody MemberJoinEntity dto){
		try {
			joinMemberUseCase.join(dto.getUserid(), dto.getPw());
			return ResponseEntity.ok("join success");
		} catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
	}
	
}
