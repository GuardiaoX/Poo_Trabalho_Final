package br.com.poo.enums.conta;

public enum TipoOperacao {
	DEP("DEPÓSITO", 1), SQ("SAQUE", 2), TRANSF("TRANSFERÊNCIA", 3);

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
