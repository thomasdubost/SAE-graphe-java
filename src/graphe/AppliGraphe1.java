package graphe;

public class AppliGraphe1 {
	public static void main(String[] args) {
		Graphe1 g = new Graphe1();
		g.add_node("ALLO");
		g.add_node("BONJOUR");
		g.add_node("SALUT");
		System.out.println(g.nodes());
		g.add_edge("ALLO", "BONJOUR","COOL");
		g.add_edge("SALUT", "ALLO");
		System.out.println(g.edges());
	}
}
