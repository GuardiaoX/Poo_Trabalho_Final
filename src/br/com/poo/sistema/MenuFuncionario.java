package br.com.poo.sistema;

import javax.swing.JOptionPane;

public class MenuFuncionario {
	public static void main(String[] args) {
		int conta = 3;
		Object[] opcoesFuncionario = {};
		Object[] opcoesGerente = { "1. Contas em sua agência", "2. Informações de conta" };
		Object[] opcoesDiretor = { "1. Relatório de clientes", "2. Relatório de gerentes" };
		Object[] opcoesPresidente = { "1. Capital total", "2. Relatório diretores e gerentes" };

		if (conta == 1) {
			opcoesFuncionario = opcoesGerente;
		} else if (conta == 2) {
			opcoesFuncionario = opcoesDiretor;
		} else if (conta == 3) {
			opcoesFuncionario = opcoesPresidente;
		}

		while (true) {
			Object valorSelecionadofun = JOptionPane.showInputDialog(null, "Menu", "Opção",
					JOptionPane.INFORMATION_MESSAGE, null, opcoesFuncionario, opcoesFuncionario[0]);
			switch (valorSelecionadofun.toString().substring(0, 1)) {
			case "1":
				if (conta == 1) {
					JOptionPane.showInternalMessageDialog(null, "Relatório:\nConta1\nConta2");
				} else if (conta == 2) {
					JOptionPane.showInternalMessageDialog(null, "Relatório:\nCliente1\nCliente2");
				} else if (conta == 3) {
					JOptionPane.showInternalMessageDialog(null, "Capital acumulado: " + "3.000.000");
				}

				break;

			case "2":
				if (conta == 1) {
					JOptionPane.showInternalMessageDialog(null, "Relatório:\nNome: \nCPF: ");
				} else if (conta == 2) {
					JOptionPane.showInternalMessageDialog(null, "Relatório:\nGerente1\nGerente2");
				} else if (conta == 3) {
					JOptionPane.showInternalMessageDialog(null, "Relatório:\nDiretor1\\nGerente2\"");
				}
				break;

			default:
				break;
			}
		}

	}
}
