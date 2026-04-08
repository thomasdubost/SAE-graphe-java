package graphe;

import java.util.ArrayList;
class NoeudExistantException extends RuntimeException {
	public NoeudExistantException(String msg) {
		super(msg);
	}
}
record Edge(String label) {};
// Graphe avec l'implémentation d'une matrice d'adjacense
public class Graphe1 {
	private ArrayList<ArrayList<Edge>> matrix;
	private ArrayList<String> nodes;
	public Graphe1() {
		this.matrix = new ArrayList<ArrayList<Edge>>();
		this.nodes = new ArrayList<String>();
	}
	public void add_node(String name){
		if (this.nodes.contains(name)) {
			throw new NoeudExistantException(name);
		}
		this.nodes.add(name);
		ArrayList<Edge> voisin = new ArrayList<Edge>();
		for (int i = 0;i<this.nodes.size();++i) {
			voisin.add(null);
		}
		for (int i = 0;i<this.nodes.size()-1;++i) {
			this.matrix.get(i).add(null);
		}
		this.matrix.add(voisin);
	}
	public void add_edge(String a_node,String b_node,String label){
		int a_index = -1;
		int b_index = -1;
		for (int i = 0;i<this.nodes.size();++i) {
			if (this.nodes.get(i).equals(a_node)){
				a_index = i;
			}
			if (this.nodes.get(i).equals(b_node)) {
				b_index = i;
			}
		}
		if (a_index == -1 || b_index ==-1) {
			throw new RuntimeException("Y'a pas");
		}
		this.matrix.get(a_index).set(b_index, new Edge(label));
	}
	public void add_edge(String a_node,String b_node) {
		add_edge(a_node, b_node,null);
	}
	public boolean contains(String node) {
		return this.nodes.contains(node);
	}
	public ArrayList<String> nodes(){
		return (ArrayList<String>) this.nodes.clone(); // SHALLOW COPY
	}
	public ArrayList<ArrayList<String>> edges(){
		ArrayList<ArrayList<String>> edges = new ArrayList<ArrayList<String>>();
		for (int i = 0;i<this.matrix.size();++i) {
			
			for (int j = 0;j<this.matrix.get(i).size();++j) {
				
				if (this.matrix.get(i).get(j)!=null) {
					ArrayList<String> t_edge = new ArrayList<String>();
					t_edge.add(this.nodes.get(i));
					t_edge.add(this.nodes.get(j));
					t_edge.add(this.matrix.get(i).get(j).label());
					edges.add(t_edge);
				}
			}
			
		}
		return edges;
	};
}
