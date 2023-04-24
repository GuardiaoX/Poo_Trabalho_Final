package br.com.poo.enums;

public enum TipoPessoa {
	
	
	CLIENTE("CLIENTE", 1),
	FUNCIONARIO("FUNCIONARIO", 2);
	
	private String tipoPessoa;
	private int id;

	private TipoPessoa(String tipoPessoa, int id) {
		this.tipoPessoa = tipoPessoa;
		this.id = id;
	}

	public String getTipoPessoa() {
		return tipoPessoa;
	}

	public int getId() {
		return id;
	}
	
}
