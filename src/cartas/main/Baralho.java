package cartas.main;

import cartas.enums.Face;
import cartas.enums.Naipe;

import java.util.Random;

public class Baralho {
  private Carta[] deque;
  private int cartaTopo;

  public static final int NUMERO_DE_CARTAS = 52;
  private static final Random random = new Random();

  public Baralho() {
    this.deque = new Carta[NUMERO_DE_CARTAS];
    this.cartaTopo = 0;

    Face[] faces = Face.values();
    Naipe[] naipes = Naipe.values();

    for (int i = 0; i < deque.length; i++) {
      deque[i] = new Carta(naipes[i / faces.length], faces[i % faces.length]);
    }
  }

  public void embaralhar() {
    this.cartaTopo = 0;

    for (int i = 0; i < deque.length; i++) {
      int j = random.nextInt(NUMERO_DE_CARTAS);

      Carta temp = deque[i];
      deque[i] = deque[j];
      deque[j] = temp;
    }
  }

  public Carta darUmaCarta() {
    Carta carta = null;

    if (this.cartaTopo < this.deque.length) {
      carta = this.deque[cartaTopo++];
    }

    return carta;
  }
}
