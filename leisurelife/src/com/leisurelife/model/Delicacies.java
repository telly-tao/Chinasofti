package com.leisurelife.model;

import java.util.Date;

public class Delicacies {
	private int delicacies_id;
	private String label;
	private String address;
	private int avgs;
	private String image;
	private String calls;
	private String mapx;
	private String mapy;
	private Date name;
	public int getDelicacies_id() {
		return delicacies_id;
	}
	public void setDelicacies(int delicacies_id) {
		this.delicacies_id = delicacies_id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAvgs() {
		return avgs;
	}
	public void setAvgs(int avgs) {
		this.avgs = avgs;
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
	public Date getName() {
		return name;
	}
	public void setName(Date name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Delicacies [delicacies=" + delicacies_id + ", label=" + label + ", address=" + address + ", avgs=" + avgs
				+ ", image=" + image + ", calls=" + calls + ", mapx=" + mapx + ", mapy=" + mapy + ", name=" + name
				+ "]";
	}
	
}
