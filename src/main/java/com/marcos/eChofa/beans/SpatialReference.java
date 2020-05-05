package com.marcos.eChofa.beans;

public class SpatialReference {
	
	private int wkid;
	private int latestWkid;
	
	
	public int getWkid() {
		return wkid;
	}
	public void setWkid(int wkid) {
		this.wkid = wkid;
	}
	public int getLatestWkid() {
		return latestWkid;
	}
	public void setLatestWkid(int latestWkid) {
		this.latestWkid = latestWkid;
	}
	
	
	
	@Override
	public String toString() {
		return "SpatialReference [wkid=" + wkid + ", latestWkid=" + latestWkid + "]";
	}
	
	
	

}
