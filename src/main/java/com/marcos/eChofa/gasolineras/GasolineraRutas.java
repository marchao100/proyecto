package com.marcos.eChofa.gasolineras;


import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.marcos.eChofa.beans.GasolineraAux;
import com.marcos.eChofa.servicios.Autenticacion;
import com.marcos.eChofa.servicios.ObtieneDatosUserService;
import com.marcos.eChofa.servicios.ServicioConsulta;
import com.marcos.eChofa.usuarios.Usuario;


@Controller
public class GasolineraRutas {
	
	@Autowired
	ServicioConsulta servicioConsulta;
	
	@Autowired
	ObtieneDatosUserService servicioDatos;
	
	@GetMapping("/prueba")
	public ModelAndView pruebaGET() throws URISyntaxException {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("prueba");
		
		servicioConsulta.obtenProvincias();
		
		return model;
	}
	
	
	@GetMapping("/inicio")
	public ModelAndView principal(Authentication authentication) throws URISyntaxException {
		
		ModelAndView model = new ModelAndView();		
		model.setViewName("index");
		model.addObject("combustible", servicioDatos.getCombustible(authentication.getName()));
		
		List<GasolineraAux> listaGasolineras;
		listaGasolineras = servicioConsulta.consultaInicial(servicioDatos.getArea(authentication.getName()), servicioDatos.getCombustible(authentication.getName()));
		System.out.println(listaGasolineras);
		if(checkAllPricesNotNull(listaGasolineras)) {
			model.addObject("gasolineras", listaGasolineras);
			model.addObject("flag",true);
		}else {
			//No hay ninguna gasolinera con lo que el usuario quiere
			model.addObject("flag",false);
			model.addObject("usuarioAux", new Usuario());
		}
		
		return model;
	}
	
	@GetMapping("/inicio/provincial")
	public ModelAndView mostrarProvinciales(Authentication authentication) throws URISyntaxException {
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		model.addObject("combustible", servicioDatos.getCombustible(authentication.getName()));
		
		List<GasolineraAux> listaGasolineras;
		listaGasolineras = servicioConsulta.consultaDondeHayCombustible(servicioDatos.getCombustible(authentication.getName()), servicioDatos.getProvincia(authentication.getName()));
		
		if(checkAllPricesNotNull(listaGasolineras)) {
			model.addObject("gasolineras", listaGasolineras);
			model.addObject("flag",true);
		}else {
			//No hay ninguna gasolinera con lo que el usuario quiere
			model.addObject("flag",false);
			model.addObject("usuarioAux", new Usuario());
		}
		
		return model;
	}
	
	

	
	
	
	
	/**
	 * Método para comprobar que alguna gasolinera de la zona vende el combustible solicitado
	 * @param List<GasolineraAux> gasolineras
	 * @return true si alguien vende. False si no.
	 */
	private boolean checkAllPricesNotNull(List<GasolineraAux> gasolineras) {
		
		for (GasolineraAux gasolineraAux : gasolineras) {
			if(!gasolineraAux.getPrecio().equals("NO HAY")) {
				return true;
			}
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
