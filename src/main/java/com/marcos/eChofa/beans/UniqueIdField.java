package com.marcos.eChofa.beans;

public class UniqueIdField {

	private String name;
	private boolean isSystemMaintained;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isSystemMaintained() {
		return isSystemMaintained;
	}
	public void setSystemMaintained(boolean isSystemMaintained) {
		this.isSystemMaintained = isSystemMaintained;
	}
	
	
	@Override
	public String toString() {
		return "UniqueIdField [name=" + name + ", isSystemMaintained=" + isSystemMaintained + "]";
	}
	
	
	
}
