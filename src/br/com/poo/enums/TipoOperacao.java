package br.com.poo.enums;

public enum TipoOperacao {
	DEP("DEPOSITO", 1), SQ("SAQUE", 2), TRANSF("TRANSFERENCIA", 3);

	private String tipoOperacao;
	private int id;

	TipoOperacao(String tipoOperacao, int id) {
		this.tipoOperacao = tipoOperacao;
		this.id = id;
	}

	public String getTipoOperacao() {
		return tipoOperacao;
	}

	public int getId() {
		return id;
	}
}
