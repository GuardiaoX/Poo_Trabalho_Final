package br.com.poo.enums;

public enum TipoCliente {
	PADRAO ("PADRAO", 1);
	String tipoCliente;
	int id;
	
	TipoCliente(String tipoCliente, int id) {
		this.tipoCliente = tipoCliente;
		this.id = id;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public int getId() {
		return id;
	}
}
