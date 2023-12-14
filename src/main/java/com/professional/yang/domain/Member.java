package com.professional.yang.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
public class Member {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String userid;
	
	private String pw;
	
	private String roles;
	
	protected Member() {}
	
	private Member (Long id, String userid, String pw, String roleUser) {
		this.id = id;
		this.userid = userid;
		this.pw = pw;
		this.roles = roleUser;
	}
	
	
	public static Member createUser(String userId, String pw, PasswordEncoder passwordEncoder) {
		return new Member(null, userId, passwordEncoder.encode(pw), "USER");
	}

	public Long getId() {
		return id;
	}

	public String getUserid() {
		return userid;
	}

	public String getPw() {
		return pw;
	}

	public String getRoles() {
		return roles;
	}

	
	
}
