package it.polito.tdp.PremierLeague.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.PremierLeague.db.PremierLeagueDAO;

public class Model {
	
	private Graph<Player, DefaultWeightedEdge> grafo;
	private PremierLeagueDAO dao;
	private Map<Integer,Player> idMapVertici;
	
	public Model() {
		super();
		dao = new PremierLeagueDAO();
	}
	
	public void creaGrafo(Double soglia) {
		this.grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		this.idMapVertici = new HashMap<>();
		
		for(Player p : dao.getPlayers(soglia)) {
			idMapVertici.put(p.getPlayerID(), p);
		}
		
		// vertici
		Graphs.addAllVertices(this.grafo, this.idMapVertici.values());
		
		// archi
		for(Arco ai : dao.getConnections()) {
			Player p1 = idMapVertici.get(ai.getP1());
			Player p2 = idMapVertici.get(ai.getP2());
			
			if(p1 != null && p2 != null) {
				if(ai.getPeso() < 0) {
					Graphs.addEdgeWithVertices(this.grafo, p2, p1, Math.abs(ai.getPeso()));
				}else {
					Graphs.addEdgeWithVertices(this.grafo, p1, p2, ai.getPeso());
				}
			}
		}
	    
	}
	
	public int nVertici() {
		return this.grafo.vertexSet().size();
	}
	
	public int nArchi() {
		return this.grafo.edgeSet().size();
	}
	
	public Player getTopPlayer() {
		Integer max = Integer.MIN_VALUE;
	    Player best = null;
	    
	    for(Player pi : this.grafo.vertexSet()) {
	    	if (this.grafo.outDegreeOf(pi) > max) {
	    		max = this.grafo.outDegreeOf(pi);
	    		best = pi;
	    	}
	    }
	    
	    return best;
	}
	
	public List<Sconfitto> getSconfitti(){
		Player p = this.getTopPlayer();
		List<Sconfitto> avvBattuti = new ArrayList<>();
		
		for(DefaultWeightedEdge e : grafo.outgoingEdgesOf(p)) {
			avvBattuti.add(new Sconfitto(grafo.getEdgeTarget(e),(int)grafo.getEdgeWeight(e)));
		}
		
		Collections.sort(avvBattuti);
		return avvBattuti;
	}
	
	// ULTIMO PUNTO NON FUNZIONANTE
	
	

}
