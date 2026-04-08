package graphe.exception;
/**
 * {@code GrapheException} est une superclasse d'exception qui peuvent être invoquées durant l'utilisant du package Graphe.
 * {@code GrapheException} et ses sous-classes sont des {@code RuntimeException}, qui n'ont donc pas besoin d'être déclarées dans une méthode ou un constructeur
 * Java Virtual Machine.
 */
public class GrapheException extends RuntimeException {
	private static final long serialVersionUID = -6816628227744767509L;
	public GrapheException(String msg) {
		super(msg);
		}
}