package br.com.poo.sistema;

import java.io.IOException;
import java.math.BigDecimal;

import javax.swing.JOptionPane;

import br.com.poo.enums.TipoFuncionario;
import br.com.poo.cargos.Funcionario;

public class MenuFuncionario {
	public static void telaFuncionario() throws IOException {
		Object[] opcoesFuncionario = {};
		Object[] opcoesPresidente = { "1. Capital Total no Banco", "2. Relatório Diretores e Gerentes" };
		Object[] opcoesDiretor = { "1. Relatório de Clientes", "2. Relatório de Gerentes" };
		Object[] opcoesGerente = { "1. Relatório Total Contas", "2. Relatório de Conta" };
		Funcionario func = Login.usuarioFunc;
		String tipoFunc = func.getTipoFuncionario();
		String imprssSucss = "Relatório impresso com sucesso!";
		String faltouTempo = "Em desenvolvimento.";
		int tipoFuncId = 0;
		if (tipoFunc.equals(TipoFuncionario.PRESIDENTE.getTipoFuncionario())) {
			opcoesFuncionario = opcoesPresidente;
			tipoFuncId = 1;
		} else if (tipoFunc.equals(TipoFuncionario.DIRETOR.getTipoFuncionario())) {
			opcoesFuncionario = opcoesDiretor;
			tipoFuncId = 2;
		} else if (tipoFunc.equals(TipoFuncionario.GERENTE.getTipoFuncionario())) {
			opcoesFuncionario = opcoesGerente;
			tipoFuncId = 3;
		}
		while (true) {
			Object valorSelecionadofun = JOptionPane.showInputDialog(null, "Menu Principal", "Opções",
					JOptionPane.INFORMATION_MESSAGE, null, opcoesFuncionario, opcoesFuncionario[0]);
			switch (valorSelecionadofun.toString().substring(0, 1)) {
			case "1":
				if (tipoFuncId == 1) {
					Relatorio.relatorioCapitalDoBanco(new BigDecimal("4000.50"));
					JOptionPane.showInternalMessageDialog(null, imprssSucss);		
				} else if (tipoFuncId == 2) {
					Relatorio.relatorioClientesDoBanco();
					JOptionPane.showInternalMessageDialog(null, imprssSucss);
				} else if (tipoFuncId == 3) {
					JOptionPane.showInternalMessageDialog(null, faltouTempo);
				}
				break;
			case "2":
				if (tipoFuncId == 1) {
					JOptionPane.showInternalMessageDialog(null, faltouTempo);
				} else if (tipoFuncId == 2) {
					JOptionPane.showInternalMessageDialog(null, faltouTempo);
					break;
				} else if (tipoFuncId == 3) {
					JOptionPane.showInternalMessageDialog(null, faltouTempo);
					break;
				}
				break;
			}
		}
	}
}
