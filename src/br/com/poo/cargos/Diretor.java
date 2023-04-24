package br.com.poo.cargos;

public class Diretor extends Funcionario {
	private String agenciaDiretor;
	
	public Diretor() {

	}

	public Diretor(String tipoPessoa, String tipoFuncionario, String nome, String cpf, String senha, String salario, String agenciaDiretor) {
		super(tipoPessoa, tipoFuncionario, nome, cpf, senha, salario);
		this.agenciaDiretor = agenciaDiretor;
	}
	public String getAgenciaDiretor() {
		return agenciaDiretor;
	}

}