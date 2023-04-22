package br.com.poo.enums.conta;

public enum TributacaoTipo {
	TRIB_PAD("PADRÃO GERAL", 1), TRIB_INSENTO("PADRÃO INSENÇÃO", 2);

	private String tributacaoTipo;
	private int id;

	TributacaoTipo(String tributacaoTipo, int id) {
		this.tributacaoTipo = tributacaoTipo;
		this.id = id;
	}

	public String getTributacaoTipo() {
		return tributacaoTipo;
	}

	public int getId() {
		return id;
	}
}
