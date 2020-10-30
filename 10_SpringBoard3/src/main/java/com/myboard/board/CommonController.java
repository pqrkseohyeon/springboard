package com.myboard.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {
	
	@GetMapping("/customLogin")
	public void logincheck(String error, String logout, Model model) {
		System.out.println("customLogin");
		
		if(error!=null) model.addAttribute("error", "Login Error Check Your Account");
		if (logout!=null) model.addAttribute("logout", "Logout!!");
		
	}	
}
