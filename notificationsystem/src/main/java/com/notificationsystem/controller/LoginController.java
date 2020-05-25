package com.notificationsystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	
	@GetMapping("msg")
	public String getMessage() {
		return "hello";
	}
}
