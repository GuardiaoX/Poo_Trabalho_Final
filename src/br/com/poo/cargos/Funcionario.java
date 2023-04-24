package br.com.poo.cargos;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public abstract class Funcionario extends Pessoa {

	public static Map<String, Funcionario> mapaFuncionarios = new HashMap<String, Funcionario>();
	public static TreeMap<String, Funcionario> ordenaFuncionarios = new TreeMap<>();

	private String tipoFuncionario;
	private BigDecimal salario;

	public Funcionario() {
	}

	public Funcionario(String tipoPessoa, String tipoFuncionario, String nome, String cpf, String senha, String salario) {
		super(tipoPessoa, nome, cpf, senha);
		this.tipoFuncionario = tipoFuncionario;
		this.salario = new BigDecimal(salario);
	}

	public String getTipoFuncionario() {
		return tipoFuncionario;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	
	public BigDecimal calcularFolhaPagamento(Funcionario nome) {
		return nome.getSalario().add(nome.getBonificacao());
	}

	public BigDecimal getBonificacao() {
		return getSalario().multiply(new BigDecimal("0.10"));
	}

}







