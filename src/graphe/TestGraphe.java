package graphe;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.AssertionFailedError;

class TestGraphe {
	
	boolean TesterGraphe(IGraphe g) {
		try {
		assertTrue(g.nodes().size()==0);
		assertTrue(g.edges().size()==0);
		
		g.add_node("A");
		assertTrue(g.contains("A"));
		assertTrue(g.nodes().size()==1);
		g.add_node("B");
		assertTrue(g.contains("B"));
		assertTrue(g.nodes().size()==2);
		g.add_edge("A", "B");
		assertTrue(g.edges().size()==1);
		assertTrue(g.edges().get(0).get(0)=="A"); // Le noeud parent est bien A
		assertTrue(g.edges().get(0).get(1)=="B"); // Le noeud enfant est bien B
		assertTrue(g.edges().get(0).get(2)==null); // Il n'y a bien pas de label sur cet arc
		
		g.add_node("C");
		g.add_edge("A", "C","Create");
		assertTrue(g.edges().size()==2);
		assertTrue(g.edges().get(1).get(1)=="C");
		assertTrue(g.edges().get(1).get(2)=="Create"); // Le label est bien enregistré
		return true;
		}catch (AssertionFailedError A) {
			return false;
		}
	}
	
	@Test
	void TestGraphe1() {
		assertTrue(TesterGraphe(new Graphe1()));
		
	}
	@Test
	void TestGraphe2() {
		assertTrue(TesterGraphe(new Graphe2()));
	}

}
