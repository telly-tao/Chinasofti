package com.leisurelife.model;

public class Hotedetail {
	private int pk_id;
	private int fk_id;
	private String name;
	private String image;
	private int oldprice;
	private int newprice;
	public int getPk_id() {
		return pk_id;
	}
	public void setPk_id(int pk_id) {
		this.pk_id = pk_id;
	}
	public int getFk_id() {
		return fk_id;
	}
	public void setFk_id(int fk_id) {
		this.fk_id = fk_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getOldprice() {
		return oldprice;
	}
	public void setOldprice(int oldprice) {
		this.oldprice = oldprice;
	}
	public int getNewprice() {
		return newprice;
	}
	public void setNewprice(int newprice) {
		this.newprice = newprice;
	}
	@Override
	public String toString() {
		return "Hotedetail [pk_id=" + pk_id + ", fk_id=" + fk_id + ", name=" + name + ", image=" + image + ", oldprice="
				+ oldprice + ", newprice=" + newprice + "]";
	}
	
}
