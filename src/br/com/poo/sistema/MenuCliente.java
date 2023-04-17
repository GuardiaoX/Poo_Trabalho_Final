package br.com.poo.sistema;

import javax.swing.JOptionPane;

public class MenuCliente {
	static Object[] opcoesSimNao = { "Sim", "Não" };

	public static void main(String[] args) {

		int conta = 3;

		Object[] opcoesCliente = { "1. Verificar saldo", "2. Sacar", "3. Depositar", "4. Transferir" };

		Object[] opcoesClientep = { "1. Verificar saldo", "2. Sacar", "3. Depositar", "4. Transferir",
				"5. Relatório da Poupança" };
		Object[] opcoesClientec = { "1. Verificar saldo", "2. Sacar", "3. Depositar", "4. Transferir",
				"5. Relatório de Tributos" };
		Object[] opcoesClientea = { "1. Verificar saldo", "2. Sacar", "3. Depositar", "4. Transferir",
				"5. Relatório da poupança", "6. Relatório de tributos" };
		if (conta == 1) {
			opcoesCliente = opcoesClientep;
		} else if (conta == 2) {
			opcoesCliente = opcoesClientec;
		} else if (conta == 3) {
			opcoesCliente = opcoesClientea;
		}

		// Inicia o ciclo do menu
		while (true) {
			Object valorSelecionadocli = JOptionPane.showInputDialog(null, "Menu", "Opção",
					JOptionPane.INFORMATION_MESSAGE, null, opcoesCliente, opcoesCliente[0]);

			switch (valorSelecionadocli.toString().substring(0, 1)) {
			case "1":
				// Verificar Saldo
				JOptionPane.showMessageDialog(null, "Saldo disponível: RS$" + "3000");

				break;
			case "2":
				// Sacar
				try {
					if (Integer.parseInt(JOptionPane.showInputDialog(
							"Saldo disponível: RS$" + "3000" + "\n\nDigite o valor que deseja sacar:")) > 0) {

						if (JOptionPane.showOptionDialog(null, "Deseja realmente sacar R$" + "3000" + "?", null, 0,
								JOptionPane.INFORMATION_MESSAGE, null, opcoesSimNao, null) > 0) {
							// Se sim
						} else {
							// Se não
						}
					}
				} catch (java.lang.NumberFormatException e) {
					System.out.println("peguei");
				}
				break;
			case "3":
				// Sacar
				JOptionPane
						.showInputDialog("Saldo disponível: RS$" + "3000" + "\n\nDigite o valor que deseja depositar:");
				if (JOptionPane.showOptionDialog(null, "Deseja realmente depositar R$" + "3000" + "?", null, 0,
						JOptionPane.INFORMATION_MESSAGE, null, opcoesSimNao, null) == 0) {
					// Se sim
				} else {
					// Se não
				}
				break;
			case "4":
				// Trasferir
				JOptionPane.showInputDialog(
						"Saldo disponível: RS$" + "3000" + "\n\nDigite o valor que deseja trasnferir:");
				JOptionPane.showInputDialog(
						"Saldo disponível: RS$" + "3000" + "\n\nDigite o CPF da conta que deseja trasferir:");
				if (JOptionPane.showOptionDialog(null,
						"Deseja realmente transferir R$" + "3000" + " para " + "pessoa" + "?", null, 0,
						JOptionPane.INFORMATION_MESSAGE, null, opcoesSimNao, null) == 0) {
					// Se sim
				} else {
					// Se não
				}
				break;
			case "5":
				if (conta == 1 || conta == 3) {
					JOptionPane.showInternalMessageDialog(null, "Relatório:\nJaneiro\nFevereiro");

				}
				if (conta == 2) {
					JOptionPane.showInternalMessageDialog(null, "Relatório:\nTransferencia X\nTransferencia Y");

				}
				break;
			case "6":
				if (conta == 3) {
					JOptionPane.showInternalMessageDialog(null, "Relatório:\nTransferencia X\nTransferencia Y");

				}
				break;
			default:
				break;
			}

		}
	}
}
