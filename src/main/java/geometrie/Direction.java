package geometrie;
import java.util.Random;

public enum Direction {
  EST(1, 0), NORD_EST(1, 1), NORD(0, 1), NORD_OUEST(-1, 1),
  OUEST (-1, 0), SUD_OUEST(-1, -1), SUD(0, -1), SUD_EST(1, -1);
  
  // d�placement relatif de la direction
  private final int dx, dy;

  private Direction(int dx, int dy) {
    this.dx = dx; this.dy = dy;
  }

  public int dx() {
    return dx;
  }
  public int dy() {
    return dy;
  }


  /** Retourne une direction dérivée par rapport à la
   * direction courante d'un angle aléatoirement choisi et
   * compris entre -45° et +45°.
   * @return la nouvelle direction
   */
  public Direction deriver() {
    Random rd = new Random();
    int d = (8 + this.ordinal() + (rd.nextInt( 3) - 1)) % 8;
    return Direction.values()[d];
  }
}
