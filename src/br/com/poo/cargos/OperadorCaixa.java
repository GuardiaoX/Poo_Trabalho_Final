package br.com.poo.cargos;

import java.util.HashMap;
import java.util.Map;

public class OperadorCaixa extends Funcionario{
	public static Map<String, OperadorCaixa> mapaOperadorCaixa = new HashMap<String, OperadorCaixa>();
	
	public OperadorCaixa() {
		mapaOperadorCaixa.putIfAbsent(nome, this);
		mapaPessoa.putIfAbsent(nome, this);
	}	
}
