package br.com.poo.contas;

public class ContaCorrente extends Conta {

	private Integer totalSaques = 0;
	private Integer totalDepositos = 0;
	private Integer totalTransferencias = 0;
	private Double totalTributado = 0.0;

	public ContaCorrente() {
		super();
	}

	public ContaCorrente(String tipoConta, String agencia, String numConta, String titular, String cpf, Double saldo) {
		super(tipoConta, agencia, numConta, titular, cpf, saldo);
	}

	public Integer getTotalSaques() {
		return totalSaques;
	}

	public Integer getTotalDeposito() {
		return totalDepositos;
	}

	public Integer getTotalTransferencia() {
		return totalTransferencias;
	}

	public Double getTotalTributado() {
		return totalTributado;
	}

	@Override

	public void sacar(Double valor) {
		if (super.saldo >= valor + 0.1) {
			super.saldo -= valor + 0.1;
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
			super.saldo = valor - 0.1;
			super.saldo += valor;
			System.out.println("Operação realizada com sucesso!\n");
			System.out.printf("Valor depositado: R$%.2f ", valor, "\n");
			System.out.printf("Taxa para depósito: R$ 0.10\n");
			System.out.printf("Saldo atual: R$%.2f ", super.saldo);
			++totalDepositos;
		}
	}
	
	@Override

	public void transferir(Double valor, Conta destino) {
		if (super.saldo >= valor + 0.2) {
			super.saldo -= valor + 0.2;
			destino.depositar(valor);
			System.out.println("Operação realizada com sucesso!\n");
			System.out.printf("Valor transferido: R$%.2f", valor, "\n");
			System.out.printf("Taxa de transferência: R$ 0.20\n");
			System.out.printf("Saldo atual: R$%.2f " + super.saldo);
			++totalTransferencias;
		} else {
			System.out.println("Valor inserido + taxa de transferência excede o saldo disponível!");
		}
	}
}
