package com.zhxqqmap;

import java.io.Serializable;

public class MapData implements Serializable{
	/**
	 * 
	 */

	private String picData;
	private String locationData;
	private String localPath;

	public String getPicData() {
		return picData;
	}

	public void setPicData(String picData) {
		this.picData = picData;
	}

	public String getLocationData() {
		return locationData;
	}

	public void setLocationData(String locationData) {
		this.locationData = locationData;
	}

	

	@Override
	public String toString() {
		return "MapData [picData=" + picData + ", locationData=" + locationData
				+ ", localPath=" + localPath + "]";
	}

	public String getLocalPath() {
		return localPath;
	}

	public void setLocalPath(String localPath) {
		this.localPath = localPath;
	}

}
