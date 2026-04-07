package chenille.ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.util.function.Supplier;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.WindowConstants;

public class Frame extends JFrame {
    private static final long serialVersionUID = 1L;

    private final int tailleCase;
    private final ZoneDessin zoneDessin;
    private final JLabel labelEtat;
    private final Timer timer;

    private Runnable actionAnimation = () -> {};
    private Supplier<String> fournisseurTexte = () -> "";
    private Supplier<List<Disque>> fournisseurDisques = List::of;

    public Frame(int largeurPixels, int hauteurPixels, int tailleCase, int delaiMs) {
        this.tailleCase = tailleCase;

        this.zoneDessin = new ZoneDessin();
        this.labelEtat = new JLabel("");
        this.timer = new Timer(delaiMs, e -> executerAnimation());

        JButton boutonStartStop = new JButton("Start");
        boutonStartStop.addActionListener(e -> basculerAnimation(boutonStartStop));

        JPanel panneauBas = new JPanel(new BorderLayout());
        panneauBas.add(labelEtat, BorderLayout.WEST);
        panneauBas.add(boutonStartStop, BorderLayout.EAST);

        setLayout(new BorderLayout());
        add(panneauBas, BorderLayout.SOUTH);
        add(zoneDessin, BorderLayout.CENTER);

        setTitle("Animation");
        setSize(largeurPixels, hauteurPixels);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void setActionAnimation(Runnable actionAnimation) {
        this.actionAnimation = actionAnimation;
    }

    public void setFournisseurTexte(Supplier<String> fournisseurTexte) {
        this.fournisseurTexte = fournisseurTexte;
        mettreAJourTexte();
    }

    public void setFournisseurDisques(Supplier<List<Disque>> fournisseurDisques) {
        this.fournisseurDisques = fournisseurDisques;
    }

    public int largeurGrille() {
        return Math.max(1, zoneDessin.getWidth() / tailleCase);
    }

    public int hauteurGrille() {
        return Math.max(1, zoneDessin.getHeight() / tailleCase);
    }

    public void rafraichir() {
        mettreAJourTexte();
        zoneDessin.repaint();
    }

    private void executerAnimation() {
        actionAnimation.run();
        rafraichir();
    }

    private void mettreAJourTexte() {
        labelEtat.setText(fournisseurTexte.get());
    }

    private void basculerAnimation(JButton bouton) {
        if (timer.isRunning()) {
            timer.stop();
            bouton.setText("Start");
        } else {
            timer.start();
            bouton.setText("Stop");
        }
    }

    public record Disque(int x, int y, int diametre, Color couleurRemplissage, Color couleurContour) {
    }

    private class ZoneDessin extends JPanel {
        private static final long serialVersionUID = 1L;

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            dessinerDisques(g);
        }

        private void dessinerDisques(Graphics g) {
            for (Disque disque : fournisseurDisques.get()) {
                dessinerDisque(g, disque);
            }
        }

        private void dessinerDisque(Graphics g, Disque disque) {
            int x = xPixel(disque.x(), disque.diametre());
            int y = yPixel(disque.y(), disque.diametre());

            g.setColor(disque.couleurRemplissage());
            g.fillOval(x, y, disque.diametre(), disque.diametre());

            g.setColor(disque.couleurContour());
            g.drawOval(x, y, disque.diametre(), disque.diametre());
        }

        private int xPixel(int xLogique, int diametre) {
            return xLogique * tailleCase - decalageCentrage(diametre);
        }

        private int yPixel(int yLogique, int diametre) {
            return yLogique * tailleCase - decalageCentrage(diametre);
        }

        private int decalageCentrage(int diametre) {
            return (diametre - tailleCase) / 2;
        }
    }
}