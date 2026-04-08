package graphe.exception;

/**
 * {@code NoeudInexistantException} classe d'exception invoquée lorsque l'on essaie de créer un arc qui contient un noeud qui n'est pas dans le graphe.
 */
public class NoeudInexistantException extends NoeudException{
	private static final long serialVersionUID = -6555835328195039788L;

	public NoeudInexistantException(String node) {
		super(node,"inéxistant");
	}
}
