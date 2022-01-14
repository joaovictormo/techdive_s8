import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

import banco.*;
import banco.exceptions.SaldoInsuficienteException;
import cartas.enums.Face;
import cartas.enums.Naipe;
import cartas.main.Carta;


public class Main {
  public static void main(String[] args) {

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

    Scanner input = new Scanner(System.in);
    boolean repetir = true;

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

    Conta conta = null;

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
    } while (repetir);

  }


  public static void lerArquivo(String nomeArquivo) throws FileNotFoundException {
    new FileInputStream(nomeArquivo);
  }

}
