package com.leisurelife.model;

public class Recommend {
	private int recid;
	private String username;
	private String time;
	private String content;
	private int type;
	private int tid;
	public int getRecid() {
		return recid;
	}
	public void setRecid(int recid) {
		this.recid = recid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	@Override
	public String toString() {
		return "Recommend [recid=" + recid + ", username=" + username + ", time=" + time + ", content=" + content
				+ ", type=" + type + ", tid=" + tid + "]";
	}
	
	
}
