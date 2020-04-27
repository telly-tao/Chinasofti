package com.leisurelife.model;

public class Display {
	private int displayid;
	private String name;
	private String time;
	private String address;
	private String image;
	private String host;
	private String descr;
	private String calls;
	public int getDisplayid() {
		return displayid;
	}
	public void setDisplayid(int displayid) {
		this.displayid = displayid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public String getCalls() {
		return calls;
	}
	public void setCalls(String calls) {
		this.calls = calls;
	}
	@Override
	public String toString() {
		return "Display [displayid=" + displayid + ", name=" + name + ", time=" + time + ", address=" + address
				+ ", image=" + image + ", host=" + host + ", descr=" + descr + ", calls=" + calls + "]";
	}
	
}
