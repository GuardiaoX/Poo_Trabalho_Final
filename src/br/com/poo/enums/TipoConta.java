package br.com.poo.enums;

public enum TipoConta {
	CONT_CORR("CORRENTE", 1), CONT_POU("POUPANCA", 2);

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