package br.com.poo.cargos;

public class Presidente extends Funcionario {

	public Presidente() {
		this.tipoFuncionario = TipoFuncionario.PRESIDENTE;
		mapaFuncionario.putIfAbsent(nome, this);
		mapaPessoa.putIfAbsent(nome, this);
	}
}
