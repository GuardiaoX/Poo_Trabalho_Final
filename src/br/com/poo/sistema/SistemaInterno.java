package br.com.poo.sistema;

import java.io.IOException;
import java.util.Map;

import javax.swing.JOptionPane;

import br.com.poo.cargos.Cliente;
import br.com.poo.cargos.Funcionario;
import br.com.poo.cargos.Gerente;
import br.com.poo.cargos.Pessoa;

//Qualquer coisa aqui pode ser ignorada, foi apenas teste

public class SistemaInterno {
	public static void main(String[] args) throws IOException {
		Funcionario daniel = new Gerente("Daniel", "1234", "4321");
		Funcionario daniela = new Gerente("julia", "1234", "4321");
		Funcionario danielb = new Gerente("pedro", "1234", "4321");
		Funcionario danielc = new Gerente("roberto", "1234", "4321");
		Pessoa ana = new Cliente("Ana", "palma", "3322");
		Pessoa paula = new Cliente("Paula", "magalhães", "4444");
		String p = "Ana";
		
		for(int i = 0; i<45; i++) {
			 new Gerente("roberto"+i, "1234", "4321");
			
		}
		
		MenuFuncionario.main(args);
		
		
		
		System.out.println(Pessoa.mapaPessoa.get(p).toString());
//		for(Map.Entry<String, Pessoa> entry : Pessoa.mapaPessoa.entrySet()) {
//			System.out.println(entry.getValue().toString());
//			
//		}
		
	
		
//		if (JOptionPane.showInputDialog("CPF").equals(daniel.getCpf())
//				& JOptionPane.showInputDialog("Senha").equals(daniel.getSenha())) {
//			JOptionPane.showMessageDialog(null,
//					("Olá " + daniel.getNome() + "\n Qual função deseja acessar:\n1-Saldo\n2-Sacar\n3-Depositar"));
//		} else {
//			JOptionPane.showMessageDialog(null,
//					("Olá " + daniel.getNome() + ", você esqueceu que sua senha era " + daniel.getSenha()));
//		}

	}
}
