package com.marcos.eChofa.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcos.eChofa.usuarios.Usuario;
import com.marcos.eChofa.usuarios.UsuarioDAO;

@Service
public class ObtieneDatosUserService {

	@Autowired
	UsuarioDAO usuarioDAO;
	
	public String getArea(String user) {
		
		Usuario usuario = usuarioDAO.findById(user).get();
		
		return usuario.getLocalidad();
	}
	
	public String getCombustible(String user) {
		
		Usuario usuario = usuarioDAO.findById(user).get();
		
		return usuario.getCarburante();
	}
	
	public String getProvincia(String user) {
		
		Usuario usuario = usuarioDAO.findById(user).get();
		
		return usuario.getProvincia();
	}
}
