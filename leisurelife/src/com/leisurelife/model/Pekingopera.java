package com.leisurelife.model;

public class Pekingopera {
	private int pekingopera_id;
	private String name;
	private String time;
	private String image;
	private String calls;
	private String mapx;
	private String mapy;
	private String price;
	private String descr;
	private String address;
	public int getPekingopera_id() {
		return pekingopera_id;
	}
	public void setPekingopera_id(int pekingopera_id) {
		this.pekingopera_id = pekingopera_id;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
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
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Pekingopera [pekingopera_id=" + pekingopera_id + ", name=" + name + ", time=" + time + ", image="
				+ image + ", calls=" + calls + ", mapx=" + mapx + ", mapy=" + mapy + ", price=" + price + ", descr="
				+ descr + ", address=" + address + "]";
	}
	
}
