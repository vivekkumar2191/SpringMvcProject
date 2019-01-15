package org.lenovo.model;

public class Plan {
	private int namesample,precallsample,firstcallsample;
	private String name;
	
	public int getNamesample() {
		return namesample;
	}
	public void setNamesample(int namesample) {
		this.namesample = namesample;
	}
	public int getPrecallsample() {
		return precallsample;
	}
	public void setPrecallsample(int precallsample) {
		this.precallsample = precallsample;
	}
	public int getFirstcallsample() {
		return firstcallsample;
	}
	public void setFirstcallsample(int firstcallsample) {
		this.firstcallsample = firstcallsample;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Plan() {}
public Plan(String name,int namesample,int precallsample,int firstcallsample) {
	this.firstcallsample=firstcallsample;
	this.name=name;
	this.namesample=namesample;
	this.precallsample=precallsample;
	
	
	
	
	
}
}
