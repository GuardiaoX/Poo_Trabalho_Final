package br.com.poo.enums.conta;

public enum TipoConta {
	CONT_CORR("CONTA CORRENTE", 1), CONT_POU("CONTA POUPANÇA", 2);

	private String tipoConta;
	private int id;

	TipoConta(String tipoConta, int id) {
		this.tipoConta = tipoConta;
		this.id = id;
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public int getId() {
		return id;
	}
}
