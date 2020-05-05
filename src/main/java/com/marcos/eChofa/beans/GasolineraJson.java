package com.marcos.eChofa.beans;

import java.util.ArrayList;
import java.util.List;

public class GasolineraJson {
	
	private String objectIdFieldName;
	private UniqueIdField uniqueIdField;
	private String globalIdFieldName;
	private String geometryType;
	private SpatialReference spatialReference;
	private List<Field> fields = new ArrayList<Field>();
	private List<Gasolinera> features = new ArrayList<Gasolinera>();
	
	public String getObjectIdFieldName() {
		return objectIdFieldName;
	}
	public void setObjectIdFieldName(String objectIdFieldName) {
		this.objectIdFieldName = objectIdFieldName;
	}
	public UniqueIdField getUniqueIdField() {
		return uniqueIdField;
	}
	public void setUniqueIdField(UniqueIdField uniqueIdField) {
		this.uniqueIdField = uniqueIdField;
	}
	public String getGlobalIdFieldName() {
		return globalIdFieldName;
	}
	public void setGlobalIdFieldName(String globalIdFieldName) {
		this.globalIdFieldName = globalIdFieldName;
	}
	public String getGeometryType() {
		return geometryType;
	}
	public void setGeometryType(String geometryType) {
		this.geometryType = geometryType;
	}
	public SpatialReference getSpatialReference() {
		return spatialReference;
	}
	public void setSpatialReference(SpatialReference spatialReference) {
		this.spatialReference = spatialReference;
	}
	public List<Field> getFields() {
		return fields;
	}
	public void setFields(List<Field> fields) {
		this.fields = fields;
	}
	public List<Gasolinera> getFeatures() {
		return features;
	}
	public void setFeatures(List<Gasolinera> features) {
		this.features = features;
	}
	@Override
	public String toString() {
		return "GasolineraJson [objectIdFieldName=" + objectIdFieldName + ", uniqueIdField=" + uniqueIdField
				+ ", globalIdFieldName=" + globalIdFieldName + ", geometryType=" + geometryType + ", spatialReference="
				+ spatialReference + ", fields=" + fields + ", features=" + features + "]";
	}
	
	
	
	
	

	
	

}
