package com.marcos.eChofa;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RutasGenericas {
	
	@GetMapping("/logout")
	public String finalizar(Authentication authentication) {
		
		return "ok";
	}
	
	@GetMapping("/login")
	public String seguridad(HttpSession sesion) {
		
		
		return "start";
	}	

}
