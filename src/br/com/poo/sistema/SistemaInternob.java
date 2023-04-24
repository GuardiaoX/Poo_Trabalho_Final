package br.com.poo.sistema;

import java.io.IOException;

import javax.swing.JOptionPane;

import br.com.poo.sistema.Login;
/*import java.util.Map;
import javax.swing.JOptionPane;
import br.com.poo.cargos.Cliente;
import br.com.poo.cargos.Funcionario;
import br.com.poo.cargos.Gerente;
import br.com.poo.cargos.Pessoa;*/

public class SistemaInternob {
	public static void main(String[] args) throws IOException {
		LeitorBanco.leitor("banco.txt");	
		Login.login();
		if (Login.loginVerif == false) {
			JOptionPane.showMessageDialog(null, Login.fimPrograma);
			System.exit(0);
		}
//		else if (){
//			
//		}
	}
}
