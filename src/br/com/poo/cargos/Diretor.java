package br.com.poo.cargos;

public class Diretor extends Funcionario {

	public Diretor() {
		this.tipoFuncionario = TipoFuncionario.DIRETOR;
		mapaFuncionario.putIfAbsent(nome, this);
		mapaPessoa.putIfAbsent(nome, this);
	}
}
