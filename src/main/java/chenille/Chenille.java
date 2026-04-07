package chenille;

import java.util.Arrays;
import java.util.List;

public class Chenille {
    private Tete tete;
    private Anneau[] anneaux;

    public Chenille(int nbAnneaux, int xTete, int yTete) {
        this.tete = new Tete(xTete, yTete);
        this.anneaux = new Anneau[nbAnneaux];
        for (int i = 0; i < nbAnneaux; i++) {
            this.anneaux[i] = new Anneau(xTete - i - 1, yTete);
        }
    }

    public void deplacer(int xMax, int yMax) {
        for (int i = anneaux.length -1; i >0; --i)
            anneaux[i].placer(anneaux[i-1].x(), anneaux[i-1].y());
        anneaux[0].placer(tete.x(), tete.y());
        tete.deplacer(xMax, yMax);
    }

    // retourne une copie de la tete de la chenille
    public Tete tete() {
        return new Tete(tete.x(), tete.y());
    }

    // retourne une copie des anneaux de la chenille
    public List<Anneau> anneaux() {
        return Arrays.asList(anneaux);
    }
}