package br.com.poo.contas;

import br.com.poo.cargos.Agencia;
import br.com.poo.cargos.Cliente;

public abstract class Conta extends Cliente {
	double saldo;
	String CPF = this.getCpf();
	Agencia agencia = Agencia.AGENCIA1;
			
	public Conta() {	
	}

}
