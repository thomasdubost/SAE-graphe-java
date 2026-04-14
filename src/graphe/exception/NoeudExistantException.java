package graphe.exception;

/**
 * {@code NoeudExistantException} classe d'exception invoquée lorsque l'on essaie de créer noeud qui est déjà contenu dans le graphe.
 */
public class NoeudExistantException extends NoeudException{
	private static final long serialVersionUID = -5711379843166400291L;

	public NoeudExistantException(String node) {
		super(node,"éxistant");
	}
}
