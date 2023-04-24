package br.com.poo.cargos;

import java.util.HashMap;
import java.util.Map;

public abstract class Cliente extends Pessoa {
	private String tipoCliente;

	public static Map<String, Cliente> mapaCliente = new HashMap<>();

	public Cliente() {
	}

	public Cliente(String tipoPessoa, String tipoCliente, String nome, String cpf, String senha) {
		super( tipoPessoa, nome, cpf, senha);
		this.tipoCliente = tipoCliente;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}
}