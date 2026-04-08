package graphe;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

// Graphe avec l'implémentation de liste d'adjacence
public class Graphe2 implements IGraphe{
	private HashMap<String, ArrayList<String[]>> edges;
	public Graphe2() {
		this.edges = new HashMap<String, ArrayList<String[]>>();
	}
	public void add_node(String node) {
		this.edges.put(node, new ArrayList<String[]>());
	}
	public void add_edge(String a_node,String b_node,String label) {
		this.edges.get(a_node).add(new String[] {b_node,label});
	}
	public void add_edge(String a_node,String b_node) {
		add_edge(a_node, b_node,null);
	}
	public ArrayList<String> nodes(){
		return new ArrayList<String>(this.edges.keySet());
	}
	public ArrayList<ArrayList<String>> edges(){
		ArrayList<ArrayList<String>> edges = new ArrayList<ArrayList<String>>();
		for (Entry<String,ArrayList<String[]>> entry : this.edges.entrySet()) {
			if (!entry.getValue().isEmpty()) {
				for (String[] n: entry.getValue()) {
					ArrayList<String> temp = new ArrayList<String>();
					temp.add(entry.getKey());
					temp.add(n[0]);
					temp.add(n[1]);
					edges.add(temp);
				}
			}
		}
		return edges;
	}
	@Override
	public boolean contains(String node) {
		return this.edges.containsKey(node);
	};
}
