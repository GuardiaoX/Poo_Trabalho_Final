package br.com.poo.cargos;

import java.util.HashMap;
import java.util.Map;

public abstract class Pessoa {
	private String nome;
	private String cpf;
	private String senha;
	private String tipoPessoa;
	public static Map<String, Pessoa> mapaPessoa = new HashMap<>();
	
	public Pessoa() {
	}

	public Pessoa( String tipoPessoa, String nome, String cpf, String senha) {
		this.tipoPessoa = tipoPessoa;
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public String getSenha() {
		return senha;
	}

	public String getCpf() {
		return cpf;
	}

	public String getTipoPessoa() {
		return tipoPessoa;
	}
}
