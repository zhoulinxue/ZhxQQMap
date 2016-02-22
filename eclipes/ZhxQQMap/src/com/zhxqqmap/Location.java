package com.zhxqqmap;
/** * @author  作者 E-mail: 194093798@qq.com 
 * @date 创建时间：2016年2月22日 上午11:43:37 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  */
import java.io.Serializable;

public class Location implements Serializable{
	private Double latitude;
	private Double longitude;
	private String address;
	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	

}
