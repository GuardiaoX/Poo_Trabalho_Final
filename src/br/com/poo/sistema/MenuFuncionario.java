package br.com.poo.sistema;

import java.io.IOException;
import java.math.BigDecimal;

import javax.swing.JOptionPane;

import br.com.poo.enums.TipoFuncionario;
import br.com.poo.cargos.Funcionario;
import br.com.poo.cargos.Gerente;
import br.com.poo.contas.ContaPoupanca;

public class MenuFuncionario {
	public static void telaFuncionario() throws IOException {
		Object[] opcoesFuncionario = {};
		Object[] opcoesPresidente = {"1. Voltar Tela de Login", "2. Capital Total no Banco"};
		Object[] opcoesDiretor = {"1. Voltar Tela de Login", "2. Relatório de Clientes"};
		Object[] opcoesGerente = {"1. Voltar Tela de Login",  "2. Relatório de Conta da Agencia"};
		String[] opcaoBinar = { "Sim", "Não" };
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
				if (JOptionPane.showOptionDialog(null, "Gostaria de voltar à tela de login?", null, 0,
						JOptionPane.INFORMATION_MESSAGE, null, opcaoBinar, opcaoBinar[0]) == 0) {
					SistemaInterno.main(new String[0]);
					break;
				} else {
					break;
				}
			case "2":
				if (tipoFuncId == 1) {
					Relatorio.relatorioCapitalDoBanco();
					JOptionPane.showInternalMessageDialog(null, imprssSucss);
				} else if (tipoFuncId == 2) {
					Relatorio.relatorioClientesDoBanco();
					JOptionPane.showInternalMessageDialog(null, imprssSucss);
				} else if (tipoFuncId == 3) {
					Gerente funcRefd = (Gerente) func;
					Relatorio.relatorioContasDaAgencia(funcRefd.getAgenciaGerente());
					JOptionPane.showInternalMessageDialog(null, imprssSucss);
					break;
				}
				break;
			case "3":
				if (tipoFuncId == 1) {
					JOptionPane.showInternalMessageDialog(null, faltouTempo);
				} else if (tipoFuncId == 2) {
					JOptionPane.showInternalMessageDialog(null, faltouTempo);
					break;
				}
			default:
				break;
			}
		}

	}
}
