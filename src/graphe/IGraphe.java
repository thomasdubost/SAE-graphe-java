package graphe;

import java.util.ArrayList;

public interface IGraphe {
	void add_node(String label);
	void add_edge(String a_node,String b_node,String label);
	void add_edge(String a_node,String b_node);
	ArrayList<String> nodes();
	ArrayList<ArrayList<String>> edges();
	boolean contains(String node);
}
