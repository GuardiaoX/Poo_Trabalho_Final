package br.com.poo.cargos;

//import java.util.HashMap;
//import java.util.Map;

//10% da bonificação do Funcionario(R$ 5.00) somado a 15% sobre o seu salário;

public class Gerente extends Funcionario {
	private String agenciaGerente;

	public Gerente() {
	}

	public Gerente(String tipoPessoa, String tipoFuncionario, String nome, String cpf, String senha, String salario,
			String agenciaGerente) {
		super(tipoPessoa, tipoFuncionario, nome, cpf, senha, salario);
		this.agenciaGerente = agenciaGerente;
	}

	public String getAgenciaGerente() {
		return agenciaGerente;
	}
}