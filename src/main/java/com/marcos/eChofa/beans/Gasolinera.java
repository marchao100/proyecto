package com.marcos.eChofa.beans;

public class Gasolinera {
	
	private Attributes attributes;
	
	private Geometry geometry;
	
	

	public Attributes getAttributes() {
		return attributes;
	}

	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}

	

	public Geometry getGeometry() {
		return geometry;
	}

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

	@Override
	public String toString() {
		return "Gasolinera [attributes=" + attributes + ", geometria=" + geometry + "]";
	}
	
	
	

}
