package banco;

public class ContaCorrente extends Conta {
  double limite;
  Cliente cliente;

  public ContaCorrente(String nomeTitular, String sobrenomeTitular, double saldoInicial, double limiteInicial) throws IllegalArgumentException {
    super(saldoInicial);

    if (limiteInicial < 0) {
      throw new IllegalArgumentException("Limite inicial deve ser zero ou positivo.");
    }

    this.cliente = new Cliente(nomeTitular, sobrenomeTitular);

    this.limite = limiteInicial;

  }
}
