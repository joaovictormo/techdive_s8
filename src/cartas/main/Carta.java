package cartas.main;

import cartas.enums.Face;
import cartas.enums.Naipe;

public class Carta {

  private String naipe;
  private String face;

  public Carta(String naipe, String face) {
    this.face = face;
    this.naipe = naipe;
  }

  public String toString() {
    return face + " de " + naipe;
  }
}
