package br.com.poo.cargos;

import java.util.HashMap;
import java.util.Map;

public abstract class Pessoa {
	String nome, senha, cpf;
	TipoPessoa tipoPessoa;
	public static Map<String, Pessoa> mapaPessoa = new HashMap<String, Pessoa>();

	public Pessoa() {
	}

//Gets e Setters de pessoa
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	@Override
	public String toString() {
		return "Nome: " + nome + ", Senha: " + senha + ", CPF: " + cpf;
	}
}
