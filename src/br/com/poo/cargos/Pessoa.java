package br.com.poo.cargos;

public abstract class Pessoa {
	String nome, senha, cpf;
	tipoPessoa tipoPessoa;

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

	public tipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(tipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
}
