package com.julianoribeiro.model;

public class Casa {
	
	private int temperatura;
	private int lumens;
	
	public Casa() {};
	
	public Casa(int temp, int luz) {
		this.lumens = luz;
		this.temperatura = temp;
	}
	
	public int getTemperatura() {
		return temperatura;
	}
	
	public int getLumens() {
		return lumens;
	}

}
