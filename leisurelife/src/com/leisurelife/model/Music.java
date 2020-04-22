package com.leisurelife.model;

public class Music {
	private int musicid;
	private String name;
	private String time;
	private String address;
	private String image;
	private String descr;
	private String calls;
	private String mapx;
	private String mapy;
	private String price;
	public int getMusicid() {
		return musicid;
	}
	public void setMusicid(int musicid) {
		this.musicid = musicid;
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
	public String getMapx() {
		return mapx;
	}
	public void setMapx(String mapx) {
		this.mapx = mapx;
	}
	public String getMapy() {
		return mapy;
	}
	public void setMapy(String mapy) {
		this.mapy = mapy;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Music [musicid=" + musicid + ", name=" + name + ", time=" + time + ", address=" + address + ", image="
				+ image + ", descr=" + descr + ", calls=" + calls + ", mapx=" + mapx + ", mapy=" + mapy + ", price="
				+ price + "]";
	}
	
}
