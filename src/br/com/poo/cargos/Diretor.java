package br.com.poo.cargos;

import java.util.HashMap;
import java.util.Map;

public class Diretor extends Funcionario {
	public static Map<String, Diretor> mapaDiretor = new HashMap<String, Diretor>();
	
	public Diretor() {
		mapaDiretor.putIfAbsent(nome, this);
		mapaPessoa.putIfAbsent(nome, this);
	}
}
