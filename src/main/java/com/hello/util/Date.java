package com.hello.util;

import java.io.Serializable;

public class Date implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//[{"carrierCode":"","extNumber":null,"number":"90626532","occurTime":"2016\/7\/18 15:38:59","trackingNumber":"2009325640","warehouseCode":""
	private String carrierCode;
	private String extNumber;
	private String number;
	private String occurTime;
	private String trackingNumber;
	private String warehouseCode;
	public String getCarrierCode() {
		return carrierCode;
	}
	public void setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
	}
	public String getExtNumber() {
		return extNumber;
	}
	public void setExtNumber(String extNumber) {
		this.extNumber = extNumber;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getOccurTime() {
		return occurTime;
	}
	public void setOccurTime(String occurTime) {
		this.occurTime = occurTime;
	}
	public String getTrackingNumber() {
		return trackingNumber;
	}
	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}
	public String getWarehouseCode() {
		return warehouseCode;
	}
	public void setWarehouseCode(String warehouseCode) {
		this.warehouseCode = warehouseCode;
	}
	
}
