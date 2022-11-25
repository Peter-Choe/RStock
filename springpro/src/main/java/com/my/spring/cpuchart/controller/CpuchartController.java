package com.my.spring.cpuchart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CpuchartController {
	
	@GetMapping("/cpu/chart")
	public String showHighChart() {
		return "jsp/cpuchart";
	}
}
