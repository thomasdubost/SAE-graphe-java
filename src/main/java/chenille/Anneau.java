package chenille;

public class Anneau {
    private int x;
    private int y;

    public Anneau(int x, int y) {
        placer(x, y);
    }

    public int x() { return x; }
    public int y() {
        return y;
    }

    public void placer(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
