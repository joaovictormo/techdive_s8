package cartas.main;

import java.util.Random;

public class Baralho {
  private Carta[] deque;
  private int cartaTopo;

  public static final int NUMERO_DE_CARTAS = 52;
  private static final Random random = new Random();

  public Baralho() {
    this.deque = new Carta[NUMERO_DE_CARTAS];
    this.cartaTopo = 0;

    String[] faces = {"A", "2", "3", "4", "5", "6", "7",
        "8", "9", "10", "J", "Q", "K"};
    String[] naipes = {"COPAS", "OUROS", "ESPADAS", "PAUS"};

    for (int i = 0; i < deque.length; i++) {
      deque[i] = new Carta(naipes[i / faces.length], faces[i % faces.length]);
    }
  }
}
