package br.com.poo.cargos;

import java.util.HashMap;
import java.util.Map;

public class Presidente extends Funcionario {

	public static Map<String, Presidente> mapaPresidente = new HashMap<String, Presidente>();	
	
	public Presidente() {
		mapaPresidente.putIfAbsent(nome, this);
		mapaPessoa.putIfAbsent(nome, this);
	}
}
