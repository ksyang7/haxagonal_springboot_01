package com.professional.yang.adapter.in.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
public class StatusCheckController {

	@GetMapping
	public ResponseEntity<String> serviceStatusCheck(){
		return ResponseEntity.ok("ok");
	}
}
