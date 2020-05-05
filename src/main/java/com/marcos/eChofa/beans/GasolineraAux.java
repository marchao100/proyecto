package com.marcos.eChofa.beans;

public class GasolineraAux {
	
	private String objectId;
	private String localidad;
	private String rotulo;
	private String precio;
	private String horario;
	
	
	public String getObjectId() {
		return objectId;
	}
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getRotulo() {
		return rotulo;
	}
	public void setRotulo(String rotulo) {
		this.rotulo = rotulo;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		
		if(precio == null) {
			this.precio = "NO HAY";
		}else {
			this.precio = precio;
		}
		
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	@Override
	public String toString() {
		return "GasolineraAux [objectId=" + objectId + ", localidad=" + localidad + ", rotulo=" + rotulo + ", precio="
				+ precio + ", horario=" + horario + "]";
	}
	
	

}
