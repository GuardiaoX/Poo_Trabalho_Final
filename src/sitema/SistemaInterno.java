package sitema;

import javax.swing.JOptionPane;

import cargos.Funcionario;
import cargos.Gerente;

//Qualquer coisa aqui pode ser ignorada, foi apenas teste

public class SistemaInterno {
	public static void main(String[] args) {
		Funcionario daniel = new Gerente("Daniel", "1234", "4321");

		MenuCliente.main(args);
		
		if (JOptionPane.showInputDialog("CPF").equals(daniel.getCpf())
				& JOptionPane.showInputDialog("Senha").equals(daniel.getSenha())) {
			JOptionPane.showMessageDialog(null,
					("Olá " + daniel.getNome() + "\n Qual função deseja acessar:\n1-Saldo\n2-Sacar\n3-Depositar"));
		} else {
			JOptionPane.showMessageDialog(null,
					("Olá " + daniel.getNome() + ", você esqueceu que sua senha era " + daniel.getSenha()));
		}

	}
}
