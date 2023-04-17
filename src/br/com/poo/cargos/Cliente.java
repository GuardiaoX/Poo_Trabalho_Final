package br.com.poo.cargos;

import java.util.HashMap;
import java.util.Map;

public class Cliente extends Pessoa{
	public static Map<String, Cliente> mapaCliente = new HashMap<String, Cliente>();
	public Cliente() {}
	
	public Cliente(String nome,String senha, String CPF) {
		this.setNome(nome);
		this.setSenha(senha);
		this.setCpf(CPF);
		this.setTipoPessoa(br.com.poo.cargos.tipoPessoa.CLIENTE);
		mapaCliente.putIfAbsent(nome, this);
		mapaPessoa.putIfAbsent(nome, this);
	}
	
	
	
	
}
