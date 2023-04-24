package br.com.poo.enums;

public enum TributacaoTipo {
	TRIB_PAD("PADRAO", 1), TRIB_INSENTO("ISENCAO", 2);

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
