package com.leisurelife.model;

public class Movie {
	private int movieid;
	private String name;
	private String type;
	private String player;
	private String image;
	private String descr;
	private String timelong;
	public int getMovieid() {
		return movieid;
	}
	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPlayer() {
		return player;
	}
	public void setPlayer(String player) {
		this.player = player;
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
	public String getTimelong() {
		return timelong;
	}
	public void setTimelong(String timelong) {
		this.timelong = timelong;
	}
	@Override
	public String toString() {
		return "Movie [movieid=" + movieid + ", name=" + name + ", type=" + type + ", player=" + player + ", image="
				+ image + ", descr=" + descr + ", timelong=" + timelong + "]";
	}
	
}
