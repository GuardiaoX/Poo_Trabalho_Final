package br.com.poo.sistema;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

import br.com.poo.enums.TipoPessoa;
import br.com.poo.cargos.Funcionario;
import br.com.poo.contas.Conta;

public class Login {
	static String fimPrograma = "Obrigado por utilizar nossos serviços, volte sempre! S2";
	static boolean loginVerif = false;

	private Login() {
	}

	public static void login() {
		String loginErro = "O úsuario e/ou senha estão incorretos!";
		String[] tipoPessoa = { TipoPessoa.CLIENTE.getTipoPessoa(), TipoPessoa.FUNCIONARIO.getTipoPessoa() };
		String[] opcao = { "Sim", "Não" };
		String cpf;
		String senha;
		boolean loginWhile = false;
		int entrConfirm;
		do {
			entrConfirm = JOptionPane.showOptionDialog(null, "Como você gostaria de acessar o sistema?",
					"Escolha uma opção para prosseguir:", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
					null, tipoPessoa, tipoPessoa[0]);
			if (entrConfirm == 0) {
				cpf = JOptionPane.showInputDialog("Digite seu úsuario de login: ");
				senha = JOptionPane.showInputDialog("Digite sua senha: ");
				loginVerif = false;
				for (Map.Entry<String, Conta> entry : Conta.mapaContas.entrySet()) {
					Conta value = entry.getValue();
					if (value.getCpf().equals(cpf)) {
						if (value.getSenha().equals(senha)) {
							loginVerif = true;
							break;
						}
					}
				}
				if (!loginVerif) {
					JOptionPane.showMessageDialog(null, loginErro);
					entrConfirm = JOptionPane.showOptionDialog(null, "Gostaria de tentar novamente?",
							"Escolha uma opção para prosseguir:", JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, opcao, opcao[0]);
					if (entrConfirm == 0) {
						loginWhile = false;
					} else {
						loginVerif = false;
						loginWhile = true;
						break;
					}
				} else {
					break;
				}
			} else {
				cpf = JOptionPane.showInputDialog("Digite seu úsuario de login: ");
				senha = JOptionPane.showInputDialog("Digite sua senha: ");
				loginVerif = false;
				for (Entry<String, Funcionario> entry : Funcionario.mapaFuncionarios.entrySet()) {
					Funcionario value = entry.getValue();
					if (value.getCpf().equals(cpf)) {
						if (value.getSenha().equals(senha)) {
							loginVerif = true;
							break;
						}
					}
				}
				if (!loginVerif) {
					JOptionPane.showMessageDialog(null, loginErro);
					entrConfirm = JOptionPane.showOptionDialog(null, "Gostaria de tentar novamente?",
							"Escolha uma opção para prosseguir:", JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, opcao, opcao[0]);
					if (entrConfirm == 0) {
						loginWhile = false;
					} else {
						loginVerif = false;
						loginWhile = true;
						break;
					}
				} else {
					break;
				}
			}
		} while (loginWhile != true);
	}
}
