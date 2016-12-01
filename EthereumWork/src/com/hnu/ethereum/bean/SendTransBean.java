package com.hnu.ethereum.bean;

public class SendTransBean {
	private String from = "0x391694e7e0b0cce554cb130d723a9d27458f9298"; 
	private String to ="0xafa3f8684e54059998bc3a7b0d2b0da075154d66";
	private int value;
	private String data = "";
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public double getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	
}
