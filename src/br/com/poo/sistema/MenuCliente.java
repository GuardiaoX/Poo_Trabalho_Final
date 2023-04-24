package br.com.poo.sistema;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

import javax.swing.JOptionPane;

import br.com.poo.cargos.Funcionario;
import br.com.poo.contas.Conta;
import br.com.poo.contas.ContaPoupanca;
import br.com.poo.enums.TipoConta;
import br.com.poo.enums.TipoFuncionario;

public class MenuCliente {

	public static void telaCliente() throws IOException {
		Object[] opcoesCliente = {};
		Object[] opcoesContaCorrente = { "1. Verificar saldo", "2. Sacar", "3. Depositar", "4. Transferir",
				"5. Relatório de Tributos" };
		Object[] opcoesContaPoupanca = { "1. Comprovante de Saldo", "2. Saque", "3. Depósito", "4. Transferência",
				"5. Simulação de Rendimento", "6. Comprovante de Rendimento" };
		String[] opcaoBinar = { "Sim", "Não" };
		Conta conta = Login.usuarioCl;
		String contaDest;
		Conta contaDestObj = null;
		int contaDestVerifi = 0;
		String tipoConta = conta.getTipoConta();
		String imprssSucss = "Relatório impresso com sucesso!";
		String CompSucss = "Comprovante impresso com sucesso!";
		String erro = "Houve um erro ao realizar a operação.\nTente novamente mais tarde.";
		int tipoContaId = 0;

		if (tipoConta.equals(TipoConta.CONT_CORR.getTipoConta())) {
			opcoesCliente = opcoesContaCorrente;
			tipoContaId = 1;

		} else if (tipoConta.equals(TipoConta.CONT_POU.getTipoConta())) {
			opcoesCliente = opcoesContaPoupanca;
			tipoContaId = 2;
		}
		// Inicia o ciclo do menu
		while (true) {
			Object valorSelecionadocli = JOptionPane.showInputDialog(null, "Menu", "Opção",
					JOptionPane.INFORMATION_MESSAGE, null, opcoesCliente, opcoesCliente[0]);
			switch (valorSelecionadocli.toString().substring(0, 1)) {
			case "1":
				// Saldo
				Relatorio.comprovanteSaldo(conta);
				JOptionPane.showMessageDialog(null, imprssSucss);
				break;
			case "2":
				// Sacar
				try {
					String valor = JOptionPane.showInputDialog(
							"Saldo disponível: R$" + conta.getSaldo() + "\n\nDigite o valor que deseja sacar: ");
					if (JOptionPane.showOptionDialog(null, "Deseja realmente sacar R$" + valor + "?", null, 0,
							JOptionPane.INFORMATION_MESSAGE, null, opcaoBinar, opcaoBinar[0]) == 0) {
						Boolean validi = conta.saque(new BigDecimal(valor));
						if (validi) {
							Relatorio.comprovanteSq(conta, new BigDecimal(valor));
							JOptionPane.showMessageDialog(null, CompSucss);
							break;
						} else {
							JOptionPane.showMessageDialog(null, "Saldo insuficiente.\nTente novamente mais tarde.");
						}
					} else {
						break;
					}
				} catch (java.lang.NumberFormatException e) {
					JOptionPane.showMessageDialog(null, erro);
				}
				break;
			case "3":
				// Depositar
				try {
					String valor = JOptionPane.showInputDialog(
							"Saldo disponível: R$" + conta.getSaldo() + "\n\nDigite o valor que deseja depósitar: ");
					if (JOptionPane.showOptionDialog(null, "Deseja realmente depósitar R$" + valor + "?", null, 0,
							JOptionPane.INFORMATION_MESSAGE, null, opcaoBinar, opcaoBinar[0]) == 0) {
						Boolean validi = conta.deposito(new BigDecimal(valor));
						if (validi) {
							Relatorio.comprovanteDep(conta, new BigDecimal(valor));
							JOptionPane.showMessageDialog(null, CompSucss);
							break;
						} else {
							JOptionPane.showMessageDialog(null,
									"Valor inferior ao valor de depósito mínimo.\nTente novamente mais tarde.");
						}
					} else {
						break;
					}

				} catch (java.lang.NumberFormatException e) {
					JOptionPane.showMessageDialog(null, erro);
				}
				break;
			case "4":
				// Trasferir
				try {
					String valor = JOptionPane.showInputDialog(
							"Saldo disponível: R$" + conta.getSaldo() + "\n\nDigite o valor que deseja transferir: ");
					contaDest = JOptionPane
							.showInputDialog("Digite o número da conta para a qual gostaria de transferir: ");
					for (Map.Entry<String, Conta> entry : Conta.mapaContas.entrySet()) {
						Conta value = entry.getValue();
						if (value.getNumConta().equals(contaDest)) {
							contaDestObj = value;
							contaDestVerifi = 1;
							break;
						}
					}
					if (contaDestVerifi == 1) {
						if (JOptionPane.showOptionDialog(null, "Deseja realmente transferir R$" + valor + "?", null, 0,
								JOptionPane.INFORMATION_MESSAGE, null, opcaoBinar, opcaoBinar[0]) == 0) {
							Boolean validi = conta.saque(new BigDecimal(valor));
							if (validi) {
								contaDestObj.deposito(new BigDecimal(valor));
								Relatorio.comprovanteTransferencia(conta, contaDestObj, new BigDecimal(valor));
								JOptionPane.showMessageDialog(null, CompSucss);
								break;
							} else {
								JOptionPane.showMessageDialog(null, "Saldo insuficiente.\nTente novamente mais tarde.");
							}
						} else {
							break;
						}
					} else {
						JOptionPane.showMessageDialog(null,
								"A conta de número: " + contaDest + " não existe.\nTente novamente mais tarde.");
					}

				} catch (java.lang.NumberFormatException e) {
					JOptionPane.showMessageDialog(null, erro);
				}
				break;
			// Simulado Rendimento
			case "5":
				String fimDia;
				fimDia = JOptionPane.showInputDialog("Até dia: ");
				String fimMes;
				fimMes = JOptionPane.showInputDialog("Até mês: ");
				String fimAno;
				fimAno = JOptionPane.showInputDialog("Até ano: ");
				String valor;
				valor = JOptionPane.showInputDialog("Com o valor de: ");
				BigDecimal rendiAcumuladoSimulado;
				ContaPoupanca contaRefu = (ContaPoupanca) conta;
				rendiAcumuladoSimulado = contaRefu.rendiSobreSaldoSimulado(new BigDecimal(valor),
						Integer.parseInt(fimDia), Integer.parseInt(fimMes), Integer.parseInt(fimAno));
				Relatorio.comprovanteRendiSobreSaldoSimulado(contaRefu, new BigDecimal(valor),
						contaRefu.getDiferencaDias(), rendiAcumuladoSimulado);
				JOptionPane.showInternalMessageDialog(null, CompSucss);
				break;
			case "6":
				// Rendimento
				ContaPoupanca contaRefd = (ContaPoupanca) conta;
				Boolean retornoRendiSaldo = contaRefd.rendiSobreSaldo();
				if (retornoRendiSaldo) {
					Relatorio.comprovanteRendiAcumulado(contaRefd, contaRefd.getRendiAcumulado());
					JOptionPane.showInternalMessageDialog(null, CompSucss);
				}
				break;
			default:
				break;
			}
			break;
		}
	}
}
