package br.com.poo.cargos;

public class Presidente extends Funcionario {
	
	private String tipoFuncionario;
	private String nome;
	private String cpf;
	private String senha;
	private Double salario;

	public Presidente(String tipoFuncionario, String nome, String cpf, Double salario, String senha) {
		super(tipoFuncionario, nome, cpf, senha, salario);

	}
	
	public Presidente() {
		super();
	}
	
	public Presidente(String tipoFuncionario, String nome, String cpf, String senha, Double salario) {
		super(tipoFuncionario, nome, cpf, senha, salario);
		this.tipoFuncionario = tipoFuncionario;
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.salario = salario;
	}

	public String getTipoFuncionario() {
		return tipoFuncionario;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getSenha() {
		return senha;
	}

	public Double getSalario() {
		return salario;
	}
}
