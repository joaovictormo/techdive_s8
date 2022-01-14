package cartas.main;

import cartas.enums.Face;
import cartas.enums.Naipe;

public class Carta {

  private Naipe naipe;
  private Face face;

  public Carta(Naipe naipe, Face face) {
    this.face = face;
    this.naipe = naipe;
  }

  public String toString() {
    return face.getValor() + " de " + naipe;
  }
}
