package com.professional.yang.adapter.in.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.professional.yang.config.AdminAuthorize;
import com.professional.yang.config.UserAuthorize;

@Controller
@RequestMapping("/view")
public class ViewController {

	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@GetMapping("/join")
	public String joinPage() {
		return "join";
	}
	
	@GetMapping("/dashboard")
	public String dashboardPage(@AuthenticationPrincipal User user, Model model) {
		model.addAttribute("loginId", user.getUsername());
		model.addAttribute("loginRoles", user.getAuthorities());
		return "dashboard";
	}
	
	@GetMapping("/setting/admin")
	@AdminAuthorize
	public String adminSettingPage() {
		return "admin_setting";
	}
	
	@GetMapping("/setting/user")
	@UserAuthorize
	public String userSettingPage() {
		return "user_setting";
	}
	
}
