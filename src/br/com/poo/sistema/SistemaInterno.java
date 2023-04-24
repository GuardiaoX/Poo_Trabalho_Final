package br.com.poo.sistema;

import java.io.IOException;


import javax.swing.JOptionPane;

import br.com.poo.sistema.Login;
import br.com.poo.sistema.MenuFuncionario;


public class SistemaInterno {
	public static void main(String[] args) throws IOException {
		LeitorBanco.leitor("banco.txt");	
		Login.login();
		if (Login.loginVerif == false) {
			JOptionPane.showMessageDialog(null, Login.fimPrograma);
			System.exit(0);
		}
		else if(Login.tipoPessoaLogin == 0) {
			MenuCliente.telaCliente();
		}
		else if (Login.tipoPessoaLogin == 1) {
			MenuFuncionario.telaFuncionario();
		}
	}
}
