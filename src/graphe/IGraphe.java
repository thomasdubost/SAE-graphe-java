package graphe;

import java.util.Set;

/**
 * Interface du graphe pour la SAE.
 */
public interface IGraphe {
    /**
     * Ajoute une entité au graphe.
     * @param entite l'entité à ajouter
     * @return true si l'entité a été ajoutée, false sinon
     */
    boolean ajouterEntite(IEntite entite);

    /**
     * Ajoute une relation entre deux entités.
     * @param source l'entité source
     * @param cible l'entité cible
     * @param nature la nature de la relationé
     * @return true si la relation a été ajoutée (n'était pas déjà présente), false sinon
     */
    boolean ajouterRelation(IEntite source, IEntite cible, NatureRelation nature);

    /**
     * Retourne l'ensemble des entités du graphe.
     * @return un ensemble d'entités
     */
    Set<IEntite> entites();

    /**
     * Retourne l'ensemble des relations sortantes d'une entité source.
     * @param source l'entité source
     * @return un ensemble de relations sortantes (possible ensemble vide)
     */
    Set<RelationSortante> relationsSortantes(IEntite source);

    /**
     * Retourne l'ensemble des relations entrantes d'une entité cible.
     * @param cible l'entité cible
     * @return un ensemble de relations entrantes (possible ensemble vide)
     */
    Set<RelationEntrante> relationsEntrantes(IEntite cible);
}