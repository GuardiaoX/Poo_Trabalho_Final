package br.com.poo.enums;

public enum TipoFuncionario {
	PRESIDENTE("PRESIDENTE", 1),
	DIRETOR("DIRETOR", 2),
	GERENTE("GERENTE", 3),
	OPERADOR_CAIXA("CAIXA", 4);
	
	String tipoFuncionario;
	int id;
	
	TipoFuncionario(String tipoFuncionario, int id) {
		this.tipoFuncionario = tipoFuncionario;
		this.id = id;
	}

	public String getTipoFuncionario() {
		return tipoFuncionario;
	}

	public int getId() {
		return id;
	}
}
