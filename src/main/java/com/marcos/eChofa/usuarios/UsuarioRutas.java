package com.marcos.eChofa.usuarios;




import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UsuarioRutas {

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	
	@GetMapping("/register")
	public ModelAndView registro() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("formularioUsuario");
		mav.addObject("user",new Usuario());
		
		return mav;
	}
	
	
	@PostMapping("/createUser")
	public String registrar(@ModelAttribute Usuario usuario) {
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena()));
		
		usuarioDAO.save(usuario);
		
		return "redirect:/login";
	}
	
	
	
	
	@PostMapping("/editarCombustible")
	public String editarCombustible(@ModelAttribute("usuarioAux") Usuario usuarioAux, Authentication authentication) {
		
		Optional<Usuario> usuarioOpt = usuarioDAO.findById(authentication.getName());
		if(usuarioOpt.isPresent()) {
			Usuario usuario = usuarioOpt.get();
			usuario.setCarburante(usuarioAux.getCarburante());
			usuarioDAO.save(usuario);
		}else {
			throw new Error("Error al buscar el usuario.");
		}
		
		return "redirect:/inicio";
		
	}
	
	
	
	
	@PostMapping("/editarLocalidad")
	public String editarLocalidad(@ModelAttribute("usuarioAux") Usuario usuarioAux, Authentication authentication) {
		
		Optional<Usuario> usuarioOpt = usuarioDAO.findById(authentication.getName());
		if(usuarioOpt.isPresent()) {
			Usuario usuario = usuarioOpt.get();
			usuario.setLocalidad(usuarioAux.getLocalidad());
			usuarioDAO.save(usuario);
		}else {
			throw new Error("Error al buscar el usuario.");
		}
		
		
		
		return "redirect:/inicio";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}