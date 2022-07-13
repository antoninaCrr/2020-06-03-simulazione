package it.polito.tdp.PremierLeague.model;

public class Sconfitto implements Comparable<Sconfitto> {
	
	private Player p;
	private int peso;
	
	public Sconfitto(Player p, int peso) {
		super();
		this.p = p;
		this.peso = peso;
	}
	
	public Player getP() {
		return p;
	}

	public void setP(Player p) {
		this.p = p;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return p.getPlayerID()+" "+p.getName()+" |"+this.peso;
	}

	@Override
	public int compareTo(Sconfitto o) {
		// TODO Auto-generated method stub
		return o.getPeso()-this.peso;
	}
	
	
	
	

}
