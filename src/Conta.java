public class Conta {
  double saldo;

  public Conta(double saldoInicial) throws Exception {
    if (saldoInicial <= 0) {
      throw new Exception("saldo inicial não pode ser zero nem negativo.");
    }
    this.saldo = saldoInicial;
  }

  public void sacar(double valorDoSaque) throws IllegalArgumentException {
    if (valorDoSaque > this.saldo) {
      throw new IllegalArgumentException("Saldo insuficiente. Saldo atual: " + this.getSaldo());
    } else {
      this.saldo -= valorDoSaque;
    }
  }

  public void depositar(double valorDoDeposito) {
    this.saldo += valorDoDeposito;
  }

  public double getSaldo() {
    return this.saldo;
  }
}
