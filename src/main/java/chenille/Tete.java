package chenille;

import geometrie.Direction;

public class Tete {
    private int x;
    private int y;
    private Direction cap;

    public Tete(int x, int y) {
        placer(x, y);
        this.cap = Direction.EST;
    }

    public int x() { return x; }
    public int y() {
        return y;
    }
    public Direction cap() { return cap; }

    public void deplacer(int xMax, int yMax) {
        placer((x + cap.dx() + xMax) %xMax, (y + cap.dy() + yMax) %yMax);
        cap = cap.deriver();
    }

    private void placer(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
