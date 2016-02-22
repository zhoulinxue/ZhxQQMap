package com.zhxqqmap;

import java.io.Serializable;

import com.baidu.mapapi.search.core.PoiInfo;

public class PointInfo implements Serializable {
	private Location location;
	private String address;
	public PointInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
