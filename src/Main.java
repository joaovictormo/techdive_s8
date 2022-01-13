import javax.print.DocFlavor;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
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
      System.out.println("Favor inserir o valor do saque:");

      try {
        double valorDeSaque = Double.parseDouble(input.nextLine());
        conta.sacar(valorDeSaque);
        repetir = false;
      } catch(InputMismatchException inputMismatchException) {
        System.err.println("Favor inserir um valor numérico válido.");
      } catch (IllegalArgumentException illegalArgumentException) {
        System.err.printf("%n Ocorreu um problema: %s%n", illegalArgumentException.getMessage());
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

}
