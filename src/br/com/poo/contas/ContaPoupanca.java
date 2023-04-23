package br.com.poo.contas;

public class ContaPoupanca extends Conta {
	private Integer totalSaques = 0;
	private Integer totalDepositos = 0;
	private Integer totalTransferencias = 0;
	private Double totalTributado = 0.0;

	private Double rendimento;

	public ContaPoupanca() {
		super();
	}

	public ContaPoupanca(String tipoConta, String agencia, String numConta, String titular, String cpf, Double saldo) {
		super(tipoConta, agencia, numConta, titular, cpf, saldo);
	}

	public Double calcularRendimento() {
		rendimento = 0.005 * super.getSaldo();
		return rendimento;
	}

	public Double getTotalTributado() {
		return totalTributado;
	}

	public static Double previsaoRendimento(Double valor, int dias) {
		ContaPoupanca conta = new ContaPoupanca();
		Double rendimentoTotal = conta.calcularRendimento() * dias / 30.0;
		System.out.println("O valor do rendimento para " + dias + " dias é de: R$%.2f" + rendimentoTotal);
		return rendimentoTotal;
	}

	@Override

	public void sacar(Double valor) {
		if (super.saldo >= valor + 0.6) {
			super.saldo -= valor + 0.6;
			System.out.println("Operação realizada com sucesso!\n");
			System.out.printf("Valor sacado: R$%.2f ", valor, "\n");
			System.out.printf("Taxa para saque: R$ 0.60\n");
			System.out.printf("Saldo atual: R$%.2f ", super.saldo);
			++totalSaques;
		} else {
			System.out.println("Valor inserido + o tributo excede o saldo disponível!");
		}
	}

	@Override

	public void depositar(Double valor) {
		if (super.saldo == null) {
			super.saldo = 0.0;
		} else {
			super.saldo = valor - 0.2;
			super.saldo += valor;
			System.out.println("Operação realizada com sucesso!\n");
			System.out.printf("Valor depositado: R$%.2f ", valor, "\n");
			System.out.printf("Taxa para depósito: R$ 0.20\n");
			System.out.printf("Saldo atual: R$%.2f ", super.saldo);
			++totalDepositos;
		}
	}

	@Override

	public void transferir(Double valor, Conta destino) {
		if (super.saldo >= valor + 0.4) {
			super.saldo -= valor + 0.4;
			System.out.println("Qual a conta destino?\n");
			System.out.println("Agencia:");
			System.out.println("Número da Conta:");

			destino.depositar(valor);
			System.out.println("Operação realizada com sucesso!\n");
			System.out.printf("Valor transferido: R$%.2f", valor, "\n");
			System.out.printf("Taxa de transferência: R$ 0.40\n");
			System.out.printf("Saldo atual: R$%.2f " + super.saldo);
			++totalTransferencias;
		} else {
			System.out.println("Valor inserido + taxa de transferência excede o saldo disponível!");
		}
	}
}