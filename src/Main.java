import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

import banco.*;
import banco.exceptions.SaldoInsuficienteException;
import cartas.enums.Face;
import cartas.enums.Naipe;
import cartas.main.Baralho;
import cartas.main.Carta;

public class Main {

  private static final int NUMERO_DE_JOGADORES = 4;

  public static void main(String[] args) {

    // inicio teste baralho

    Baralho baralho = new Baralho();
    baralho.embaralhar();

    String formato = "%-19s";

    for (int i = 1; i <= NUMERO_DE_JOGADORES; i++) {
      System.out.printf(formato, "Jogador " + i);
    }

    System.out.println();

    for (int i = 1; i <= Baralho.NUMERO_DE_CARTAS; i++) {
      System.out.printf(formato, baralho.darUmaCarta());

      if (i % 4 == 0) {
        System.out.println();
      }
    }

    // fim teste baralho

    //inicio teste conta corrente

    Scanner input = new Scanner(System.in);
    boolean repetir = true;

    do {
      try {
        System.out.println("Insira nome:");
        String nome = input.nextLine();
        System.out.println("Insira sobrenome:");
        String sobrenome = input.nextLine();
        System.out.println("Insira saldo inicial:");
        double saldoInicial = Double.parseDouble(input.nextLine());
        System.out.println("Insira limite inicial:");
        double limiteInicial = Double.parseDouble(input.nextLine());

        ContaCorrente cc = new ContaCorrente(nome, sobrenome, saldoInicial, limiteInicial);

        repetir = false;
      } catch(NumberFormatException numberFormatException) {
        System.err.printf("Ocorreu um erro: Insira um número válido. %s%n", numberFormatException.getMessage());
      } catch(IllegalArgumentException illegalArgumentException) {
        System.err.printf("Ocorreu um erro: %s%n", illegalArgumentException.getMessage());
      }
    } while (repetir);

    // fim teste conta corrente
/*
    try {
      lerArquivo("arquivo");
    } catch (FileNotFoundException e) {
      System.out.println("Arquivo não encontrado. Favor tentar novamente.");
    }

    for (Naipe naipe : Naipe.values()) {
      System.out.println(naipe);
    }

    Carta carta = new Carta("COPAS", "10");

    System.out.println(carta);

    String[][] array2d = new String[100][5];
    String[][][] array3d = new String[5][5][5];

    int[][] meuArrayBidi = {
        {1, 2, 7},
        {3, 4, 8},
        {5, 6, 9}
    };

    System.out.println(meuArrayBidi[0][1]);
    System.out.println(meuArrayBidi[1][0]);
    */

    /*try {
      do {
        try {
          System.out.println("Favor inserir um numerador inteiro: ");
          int numerador = input.nextInt();

          System.out.println("Favor inserir um denominador inteiro: ");
          int denominador = input.nextInt();

          int quociente = Calculadora.dividir(numerador, denominador);

          System.out.printf("Resultado: %d / %d = %d%n", numerador, denominador, quociente);
          repetir = false;
        } catch (ArithmeticException arithmeticException) {
          System.err.printf("%n Exceção: %s %n", arithmeticException);
          System.out.println("Denominador não pode ser zero.");
        } catch (InputMismatchException inputMismatchException) {
          input.nextLine();
          System.err.printf("%n Exceção: %s %n", inputMismatchException);
          System.out.println("Favor inserir um número inteiro.");
        }
      } while (repetir);
    } finally {
      input.close();
    }*/

    /*Conta conta = null;

    Conta conta2 = null;

    do {
      System.out.println("Favor inserir o valor do saldo inicial:");

      try {
        double valorSaldoInicial = Double.parseDouble(input.nextLine());
        conta = new Conta(valorSaldoInicial);
        repetir = false;
      } catch(InputMismatchException inputMismatchException) {
        System.err.println("Favor inserir um valor numérico válido.");
      } catch (Exception exception) {
        System.err.println(exception.getMessage());
      }
    } while (repetir);

    repetir = true;

    do {
      System.out.println("Favor inserir o valor do saque: ");

      try {
        double valorDeSaque = Double.parseDouble(input.nextLine());
        conta.sacar(valorDeSaque);

        System.out.println("Favor inserir valor de depósito: ");
        double valorDeDeposito = Double.parseDouble(input.nextLine());
        conta.depositar(valorDeDeposito);

        conta2 = new Conta(100);

        System.out.println("Favor inserir valor de transferência: ");
        double valorDeTransferencia = Double.parseDouble(input.nextLine());

        conta.transferir(conta2, valorDeTransferencia);

        repetir = false;
      } catch(InputMismatchException inputMismatchException) {
        System.err.println("Favor inserir um valor numérico válido.");
      } catch (SaldoInsuficienteException saldoInsuficienteException) {
        System.err.printf("%n Ocorreu um problema: %s%n", saldoInsuficienteException.getMessage());
      } catch (NullPointerException npe) {
        System.err.println("A variável conta não foi inicializada.");
      } catch (Exception exception) {
        System.err.println(exception.getMessage());
      }
    } while (repetir);

    repetir = true;

    do {
      try {
        System.out.println("Saldo atual: " + conta.getSaldo());
        repetir = false;
      } catch (Exception e) {
        System.err.println(e.getMessage());
      }
    } while (repetir);*/

  }


  public static void lerArquivo(String nomeArquivo) throws FileNotFoundException {
    new FileInputStream(nomeArquivo);
  }

}
