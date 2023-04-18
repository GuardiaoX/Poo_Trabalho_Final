package br.com.poo.cargos;

import java.util.HashMap;
import java.util.Map;

public class Gerente extends Funcionario {
	public static Map<String, Gerente> mapaGerente = new HashMap<String, Gerente>();

	public Gerente(String nome, String senha, String cpf) {
		this.setNome(nome);
		this.setSenha(senha);
		this.setCpf(cpf);
		mapaGerente.putIfAbsent(nome, this);
		mapaFuncionario.putIfAbsent(nome, this);
		mapaPessoa.putIfAbsent(nome, this);
	}


}
