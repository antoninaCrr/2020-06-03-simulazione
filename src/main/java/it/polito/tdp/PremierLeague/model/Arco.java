package it.polito.tdp.PremierLeague.model;

public class Arco {
	
	private int p1;
	private int p2;
	private double peso;
	
	
	public Arco(int p1, int p2, double peso) {
		super();
		this.p1 = p1;
		this.p2 = p2;
		this.peso = peso;
	}


	public int getP1() {
		return p1;
	}


	public void setP1(int p1) {
		this.p1 = p1;
	}


	public int getP2() {
		return p2;
	}


	public void setP2(int p2) {
		this.p2 = p2;
	}


	public double getPeso() {
		return peso;
	}


	public void setPeso(double peso) {
		this.peso = peso;
	}


	
}
