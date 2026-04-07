package chenille.ihm;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

import chenille.Anneau;
import chenille.Chenille;
import chenille.Tete;
import chenille.ihm.Frame.Disque;

public class Appli {

    private static final int LARGEUR = 600;
    private static final int HAUTEUR = 400;
    private static final int TAILLE_CASE = 20;
    private static final int DELAI = 100;

    private static final int DIAMETRE_ANNEAU = TAILLE_CASE;
    private static final int DIAMETRE_TETE = (int) (TAILLE_CASE * 1.3);

    private final Chenille chenille;
    private final Frame fenetre;

    public static void main(String[] args) {
        final int nbAnneaux = 5; // sans la tête
        final int xTete = 10;
        final int yTete = 10;

        SwingUtilities.invokeLater(() -> {
            Appli app = new Appli(nbAnneaux, xTete, yTete);
            app.demarrer();
        });
    }

    // Constructeur
    public Appli(int nbAnneaux, int xTete, int yTete) {
        this.chenille = new Chenille(nbAnneaux, xTete, yTete);
        this.fenetre = new Frame(LARGEUR, HAUTEUR, TAILLE_CASE, DELAI);

        configurerAnimation();
    }

    public void demarrer() {
        fenetre.setVisible(true);
        fenetre.rafraichir();
    }

    private void configurerAnimation() {
        fenetre.setActionAnimation(this::animerChenille);
        fenetre.setFournisseurTexte(this::textePositionTete);
        fenetre.setFournisseurDisques(this::disquesChenille);
    }

    /* ==============================
       === LIEN AVEC LE MODELE    ===
       ============================== */

    private void animerChenille() {
        chenille.deplacer(fenetre.largeurGrille(), fenetre.hauteurGrille());
    }

    private String textePositionTete() {
        Tete tete = chenille.tete();
        return "Position: (" + tete.x() + ", " + tete.y() + ")";
    }

    private List<Disque> disquesChenille() {
        List<Disque> disques = new ArrayList<>();
        ajouterDisquesAnneaux(disques);
        ajouterDisqueTete(disques);
        return disques;
    }

    private void ajouterDisquesAnneaux(List<Disque> disques) {
        for (Anneau anneau : chenille.anneaux()) {
            disques.add(creerDisqueAnneau(anneau));
        }
    }

    private void ajouterDisqueTete(List<Disque> disques) {
        disques.add(creerDisqueTete(chenille.tete()));
    }

    private Disque creerDisqueAnneau(Anneau anneau) {
        return new Disque(
                anneau.x(),
                anneau.y(),
                DIAMETRE_ANNEAU,
                Color.GREEN,
                Color.BLACK
        );
    }

    private Disque creerDisqueTete(Tete tete) {
        return new Disque(
                tete.x(),
                tete.y(),
                DIAMETRE_TETE,
                Color.RED,
                Color.BLACK
        );
    }
}
