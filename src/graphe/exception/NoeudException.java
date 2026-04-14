package graphe.exception;

/**
 * {@code NoeudException} est une superclasse d'exception qui contient les exceptions qui peuvent être invoquées durant l'utilisation du package Graphe.
 * Cette classe et ses sous-classes concernent les erreurs liés au noeud, comme par exemple lorsque l'on essaie d'ajouter un noeud qui appartient déjà au Graphe.
 */
public class NoeudException extends GrapheException{
	private static final long serialVersionUID = 8752870041669090843L;
	public NoeudException(String node,String problemType) {
		super("Il y'a un problème avec le noeud : Le noeud "+node + " " + problemType);
	}
}
