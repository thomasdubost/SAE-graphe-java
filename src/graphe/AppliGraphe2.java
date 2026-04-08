package graphe;

public class AppliGraphe2 {
	public static void main(String[] args) {
		Graphe2 g = new Graphe2();
		g.add_node("ALLO");
		g.add_node("BONJOUR");
		g.add_node("SALUT");
		System.out.println(g.nodes());
		g.add_edge("ALLO", "BONJOUR","COOL");
		g.add_edge("SALUT", "ALLO");
		System.out.println(g.edges());
	}
}
