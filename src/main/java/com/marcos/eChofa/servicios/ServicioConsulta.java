package com.marcos.eChofa.servicios;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.marcos.eChofa.beans.Gasolinera;
import com.marcos.eChofa.beans.GasolineraAux;
import com.marcos.eChofa.beans.GasolineraJson;

@Service
public class ServicioConsulta {
	
	public List<GasolineraAux> consultaInicial(String localidad, String combustible) throws URISyntaxException {
		
		URI myURL = new URI("https://services1.arcgis.com/nCKYwcSONQTkPA4K/arcgis/rest/services/Gasolinerasv2/FeatureServer/0/query?where=Localidad=%27"+ localidad + "%27&outFields=*&outSR=4326&f=json");
		RequestEntity<GasolineraJson> request = new RequestEntity<GasolineraJson>(HttpMethod.GET, myURL);
		
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();        
		//Add the Jackson Message converter
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));    
		messageConverters.add(converter);	
				
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setMessageConverters(messageConverters);
		ResponseEntity<GasolineraJson> response;
		response = 	restTemplate.exchange(request,GasolineraJson.class); 
		
		return filtraCombustibles(response.getBody().getFeatures(), combustible);
		
	}
	
	
	public List<GasolineraAux> consultaDondeHayCombustible(String combustible, String provincia) throws URISyntaxException {
		String tiposCombustible[] = new String[11];
		tiposCombustible[0] = "Precio_gasolina_95";
		tiposCombustible[1] = "Precio_gasóleo_A";
		tiposCombustible[2] = "Precio_gasóleo_B";
		tiposCombustible[3] = "Precio_bioetanol";
		tiposCombustible[4] = "Precio_nuevo_gasóleo_A";
		tiposCombustible[5] = "Precio_biodiesel";
		tiposCombustible[6] = "F__éster_metílico";
		tiposCombustible[7] = "F__bioalcohol";
		tiposCombustible[8] = "Precio_gasolina_98";
		tiposCombustible[9] = "Precio_gas_natural_comprimido";
		tiposCombustible[10] = "Precio_gas_natural_licuado";
		
		URI myURL = new URI("");
		switch (combustible) {
		case "precio_gasolina_95":
			myURL = new URI("https://services1.arcgis.com/nCKYwcSONQTkPA4K/arcgis/rest/services/Gasolinerasv2/FeatureServer/0/query?where=" + tiposCombustible[0] + "%20IS%20NOT%20NULL%20AND%20Provincia=%27"+provincia+"%27&outFields=*&outSR=4326&f=json");
			break;
		case "precio_gasoleo_a":
			 myURL = new URI("https://services1.arcgis.com/nCKYwcSONQTkPA4K/arcgis/rest/services/Gasolinerasv2/FeatureServer/0/query?where=" + tiposCombustible[1] + "%20IS%20NOT%20NULL%20AND%20Provincia=%27"+provincia+"%27&outFields=*&outSR=4326&f=json");
			break;
		case "precio_gasoleo_b":
			 myURL = new URI("https://services1.arcgis.com/nCKYwcSONQTkPA4K/arcgis/rest/services/Gasolinerasv2/FeatureServer/0/query?where=" + tiposCombustible[2] + "%20IS%20NOT%20NULL%20AND%20Provincia=%27"+provincia+"%27&outFields=*&outSR=4326&f=json");
			break;
		case "precio_bioetanol":
			 myURL = new URI("https://services1.arcgis.com/nCKYwcSONQTkPA4K/arcgis/rest/services/Gasolinerasv2/FeatureServer/0/query?where=" + tiposCombustible[3] + "%20IS%20NOT%20NULL%20AND%20Provincia=%27"+provincia+"%27&outFields=*&outSR=4326&f=json");
			break;
		case "precio_nuevo_gasoleo_a":
			 myURL = new URI("https://services1.arcgis.com/nCKYwcSONQTkPA4K/arcgis/rest/services/Gasolinerasv2/FeatureServer/0/query?where=" + tiposCombustible[4] + "%20IS%20NOT%20NULL%20AND%20Provincia=%27"+provincia+"%27&outFields=*&outSR=4326&f=json");
			break;
		case "precio_biodiesel":
			 myURL = new URI("https://services1.arcgis.com/nCKYwcSONQTkPA4K/arcgis/rest/services/Gasolinerasv2/FeatureServer/0/query?where=" + tiposCombustible[5] + "%20IS%20NOT%20NULL%20AND%20Provincia=%27"+provincia+"%27&outFields=*&outSR=4326&f=json");
			break;
		case "f__ester_metilico":
			 myURL = new URI("https://services1.arcgis.com/nCKYwcSONQTkPA4K/arcgis/rest/services/Gasolinerasv2/FeatureServer/0/query?where=" + tiposCombustible[6] + "%20IS%20NOT%20NULL%20AND%20Provincia=%27"+provincia+"%27&outFields=*&outSR=4326&f=json");
			break;
		case "f__bioalcohol":
			 myURL = new URI("https://services1.arcgis.com/nCKYwcSONQTkPA4K/arcgis/rest/services/Gasolinerasv2/FeatureServer/0/query?where=" + tiposCombustible[7] + "%20IS%20NOT%20NULL%20AND%20Provincia=%27"+provincia+"%27&outFields=*&outSR=4326&f=json");
			break;
		case "precio_gasolina_98":
			 myURL = new URI("https://services1.arcgis.com/nCKYwcSONQTkPA4K/arcgis/rest/services/Gasolinerasv2/FeatureServer/0/query?where=" + tiposCombustible[8] + "%20IS%20NOT%20NULL%20AND%20Provincia=%27"+provincia+"%27&outFields=*&outSR=4326&f=json");
			break;
		case "precio_gas_natural_comprimido":
			 myURL = new URI("https://services1.arcgis.com/nCKYwcSONQTkPA4K/arcgis/rest/services/Gasolinerasv2/FeatureServer/0/query?where=" + tiposCombustible[9] + "%20IS%20NOT%20NULL%20AND%20Provincia=%27"+provincia+"%27&outFields=*&outSR=4326&f=json");
			break;
		case "precio_gas_natural_licuado":
			 myURL = new URI("https://services1.arcgis.com/nCKYwcSONQTkPA4K/arcgis/rest/services/Gasolinerasv2/FeatureServer/0/query?where=" + tiposCombustible[10] + "%20IS%20NOT%20NULL%20AND%20Provincia=%27"+provincia+"%27&outFields=*&outSR=4326&f=json");
			break;
		}
		RequestEntity<GasolineraJson> request = new RequestEntity<GasolineraJson>(HttpMethod.GET, myURL);
		
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();        
		//Add the Jackson Message converter
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));    
		messageConverters.add(converter);	
				
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setMessageConverters(messageConverters);
		ResponseEntity<GasolineraJson> response;
		response = 	restTemplate.exchange(request,GasolineraJson.class); 
		
		System.out.println(response.getBody());

		return filtraCombustibles(response.getBody().getFeatures(), combustible);
	}
	
	public void obtenProvincias() throws URISyntaxException{
		
		URI myURL = new URI("https://services1.arcgis.com/nCKYwcSONQTkPA4K/arcgis/rest/services/Gasolinerasv2/FeatureServer/0/query?where=Precio_biodiesel%20IS%20NOT%20NULL&outFields=*&outSR=4326&f=json");
		RequestEntity<GasolineraJson> request = new RequestEntity<GasolineraJson>(HttpMethod.GET, myURL);
		
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();        
		//Add the Jackson Message converter
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));    
		messageConverters.add(converter);	
				
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setMessageConverters(messageConverters);
		ResponseEntity<GasolineraJson> response;
		response = 	restTemplate.exchange(request,GasolineraJson.class); 
		
		List<Gasolinera> gasolineras = response.getBody().getFeatures();
		
		String prov="";
		for (Gasolinera gasolinera : gasolineras) {
			if(!gasolinera.getAttributes().getProvincia().equals(prov)) {
				System.out.println(gasolinera.getAttributes().getProvincia());
				prov = gasolinera.getAttributes().getProvincia();
			}
		}
	}
	
	
 	private List<GasolineraAux> filtraCombustibles(List<Gasolinera> gasolineras, String combustible){
		
		List<GasolineraAux> listaGasolinerasAux = new ArrayList<GasolineraAux>();
		
		for (Gasolinera gasolinera : gasolineras) {
			
			GasolineraAux gasAux = new GasolineraAux();
			gasAux.setObjectId(gasolinera.getAttributes().getObjectID());
			gasAux.setLocalidad(gasolinera.getAttributes().getLocalidad());
			gasAux.setRotulo(gasolinera.getAttributes().getRotulo());
			gasAux.setHorario(gasolinera.getAttributes().getHorario());
			gasAux.setPrecio(gasolinera.getAttributes().getCombustibleDeseado(combustible));
			
			listaGasolinerasAux.add(gasAux);
		}
		
		return listaGasolinerasAux;
	}

}
