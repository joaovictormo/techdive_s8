package banco;

import banco.exceptions.SaldoInsuficienteException;

public class Conta {
  double saldo;

  public Conta(double saldoInicial) throws Exception {
    if (saldoInicial <= 0) {
      throw new Exception("saldo inicial não pode ser zero nem negativo.");
    }
    this.saldo = saldoInicial;
  }

  public void sacar(double valorDoSaque) throws SaldoInsuficienteException {
    if (valorDoSaque > this.saldo) {
      throw new SaldoInsuficienteException("Saldo insuficiente. Saldo atual: " + this.getSaldo());
    }

    this.saldo -= valorDoSaque;
    System.out.printf("Saque de R$%.2f realizado com sucesso. Novo saldo: R$%.2f.%n", valorDoSaque, this.saldo);
  }

  public void depositar(double valorDoDeposito) {
    if (valorDoDeposito <= 0) {
      throw new IllegalArgumentException("Valor do depósito precisa ser positivo.");
    }
    this.saldo += valorDoDeposito;
    System.out.printf("Valor de R$%.2f depositado com sucesso! Novo saldo: R$%.2f.%n", valorDoDeposito, this.saldo);
  }

  public double getSaldo() {
    return this.saldo;
  }

  public void transferir(Conta destino, double valorATransferir) throws SaldoInsuficienteException, NullPointerException {
      this.sacar(valorATransferir);
      destino.depositar(valorATransferir);
  }
}
