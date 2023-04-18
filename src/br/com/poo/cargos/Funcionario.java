package br.com.poo.cargos;

import java.util.HashMap;
import java.util.Map;

public abstract class Funcionario extends Pessoa {
	public static Map<String, Funcionario> mapaFuncionario = new HashMap<String, Funcionario>();

	public Funcionario() {
		this.tipoPessoa = br.com.poo.cargos.tipoPessoa.FUNCIONARIO;
	}

}
