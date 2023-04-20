package br.com.poo.cargos;

public class OperadorCaixa extends Funcionario{
	
	public OperadorCaixa() {
		this.tipoFuncionario = TipoFuncionario.OPERADORCAIXA;
		mapaFuncionario.putIfAbsent(nome, this);
		mapaPessoa.putIfAbsent(nome, this);
	}	
}
