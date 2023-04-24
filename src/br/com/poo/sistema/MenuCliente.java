package br.com.poo.sistema;

import java.io.IOException;
import java.math.BigDecimal;

import javax.swing.JOptionPane;

import br.com.poo.cargos.Funcionario;
import br.com.poo.contas.Conta;
import br.com.poo.enums.TipoConta;
import br.com.poo.enums.TipoFuncionario;

public class MenuCliente {
	
	
	public static void telaCliente() throws IOException{
		Object[] opcoesCliente = {};
		Object[] opcoesContaCorrente = { "1. Verificar saldo", "2. Sacar", "3. Depositar", "4. Transferir",
				"5. Relatório de Tributos" };
		Object[] opcoesContaPoupanca = { "1. Comprovante de Saldo", "2. Saque", "3. Depósito", "4. Transferência",
				"5. Comprovante de Rendimento", "6. Simulação de Rendimento" };
		String[] opcaoBinar = { "Sim", "Não" };
		Conta conta = Login.usuarioCl;
		String tipoConta = conta.getTipoConta();
		String imprssSucss = "Relatório impresso com sucesso!";
		String CompSucss = "Comprovante impresso com sucesso!";
		String erro = "Houve um erro ao realizar a operação, tente novamente mais tarde.";
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
				//Saldo
				Relatorio.comprovanteSaldo(conta);
				JOptionPane.showMessageDialog(null, imprssSucss);
				break;
				
				
				
				
			case "2":
				// Sacar
				try {
					String valor = JOptionPane.showInputDialog("Saldo disponível: R$" + conta.getSaldo() + "\n\nDigite o valor que deseja sacar: ");
					if (JOptionPane.showOptionDialog(null, "Deseja realmente sacar R$" + valor + "?", null, 0,
							JOptionPane.INFORMATION_MESSAGE, null, opcaoBinar, null) > 0) {
						Boolean validi = conta.saque(new BigDecimal(valor));
						if(validi) {
							Relatorio.comprovanteSq(conta, new BigDecimal(valor));
							JOptionPane.showMessageDialog(null, CompSucss);
							break;
						}
					} else {
						JOptionPane.showMessageDialog(null, "Saldo insuficiente, tente novamente mais tarde.");
						break;
					}
					
				} catch (java.lang.NumberFormatException e) {
					JOptionPane.showMessageDialog(null, erro);
				}
				break;
				
				
				
				
			case "3":
				// Depositar
				try {
					String valor = JOptionPane.showInputDialog("Saldo disponível: R$" + conta.getSaldo() + "\n\nDigite o valor que deseja depósitar: ");
					if (JOptionPane.showOptionDialog(null, "Deseja realmente depósitar R$" + valor + "?", null, 0,
							JOptionPane.INFORMATION_MESSAGE, null, opcaoBinar, null) > 0) {
						Boolean validi = conta.deposito(new BigDecimal(valor));
						if(validi) {
							Relatorio.comprovanteDep(conta, new BigDecimal(valor));
							JOptionPane.showMessageDialog(null, CompSucss);
							break;
						}
					} else {
						JOptionPane.showMessageDialog(null, "Valor inferior ao valor de depósito mínimo, tente novamente mais tarde.");
						break;
					}
					
				} catch (java.lang.NumberFormatException e) {
					JOptionPane.showMessageDialog(null, erro);
				}
				break;
				
				
				
				
				
			case "4":
				// Trasferir
				try {
					String valor = JOptionPane.showInputDialog("Saldo disponível: R$" + conta.getSaldo() + "\n\nDigite o valor que deseja transferir: ");
					
					if (JOptionPane.showOptionDialog(null, "Deseja realmente transferir R$" + valor + "?", null, 0,
							JOptionPane.INFORMATION_MESSAGE, null, opcaoBinar, null) > 0) {
						Boolean validi = conta.saque(new BigDecimal(valor));
						if(validi) {
							Relatorio.comprovanteTransferencia(conta, conta, new BigDecimal(valor));
							JOptionPane.showMessageDialog(null, CompSucss);
							break;
						}
					} else {
						JOptionPane.showMessageDialog(null, "Saldo insuficiente, tente novamente mais tarde.");
						break;
					}
					
				} catch (java.lang.NumberFormatException e) {
					JOptionPane.showMessageDialog(null, erro);
				}
				break;
				
				
				
				
//			case "5":
//				if (conta == 1 || conta == 3) {
//					JOptionPane.showInternalMessageDialog(null, "Relatório:\nJaneiro\nFevereiro");
//
//				}
//				if (conta == 2) {
//					JOptionPane.showInternalMessageDialog(null, "Relatório:\nTransferencia X\nTransferencia Y");
//
//				}
//				break;
//				
//				
//				
//				
//			case "6":
//				if (conta == 3) {
//					JOptionPane.showInternalMessageDialog(null, "Relatório:\nTransferencia X\nTransferencia Y");
//
//				}
//				break;
			default:
				break;
			}
			break;
		}
	}
}


