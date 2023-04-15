package sitema;

import javax.swing.JOptionPane;

public class MenuCliente {

	public static void main(String[] args) {
		// Define opções
		Object[] opcoesSimNao = { "Sim", "Não" };
		Object[] opcoesCliente = { "1. Verificar saldo", "2. Sacar", "3. Depositar", "4. Transferir" };

		// Inicia o ciclo do menu
		while (true) {
			Object valorSelecionado = JOptionPane.showInputDialog(null, "Menu", "Opção",
					JOptionPane.INFORMATION_MESSAGE, null, opcoesCliente, opcoesCliente[0]);

			switch (valorSelecionado.toString().substring(0, 1)) {
			case "1":
				// Verificar Saldo
				JOptionPane.showMessageDialog(null, "Saldo disponível: RS$" + "3000");

				break;
			case "2":
				// Sacar
				JOptionPane.showInputDialog("Saldo disponível: RS$" + "3000" + "\n\nDigite o valor que deseja sacar:");
				if (JOptionPane.showOptionDialog(null, "Deseja realmente sacar R$" + "3000" + "?", null, 0,
						JOptionPane.INFORMATION_MESSAGE, null, opcoesSimNao, null) == 0) {
					// Se sim
				} else {
					// Se não
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
			default:
				break;
			}

		}
	}
}
