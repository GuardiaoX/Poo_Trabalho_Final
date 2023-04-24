package br.com.poo.sistema;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import br.com.poo.contas.Conta;
import br.com.poo.contas.ContaCorrente;
import br.com.poo.contas.ContaPoupanca;
import br.com.poo.enums.TipoConta;
import br.com.poo.enums.TipoFuncionario;
import br.com.poo.cargos.OperadorCaixa;
import br.com.poo.cargos.Gerente;
import br.com.poo.cargos.Diretor;
import br.com.poo.cargos.Funcionario;
import br.com.poo.cargos.Presidente;

public class LeitorBanco {

	static final String PATH_BASICO = ".\\Bernardo\\temp2\\";
	static final String EXTENSAO = ".txt";

	public static void leitor(String path) throws IOException {
		try (BufferedReader buffRead = new BufferedReader(new FileReader(PATH_BASICO + path))) {
			String linha = "";
			while (true) {
				linha = buffRead.readLine();
				if (linha != null) {
					String[] dados = linha.split(";");
					if (dados[5].equalsIgnoreCase(TipoConta.CONT_CORR.getTipoConta())) {
						ContaCorrente cc = new ContaCorrente(dados[0], dados[1], dados[2], dados[3], dados[4], dados[5],
								dados[6], dados[7], dados[8]);
						String chaveOrdMap = dados[2] + dados[7];
						Conta.mapaContas.put(dados[7], cc);
						Conta.ordenaContas.put(chaveOrdMap, cc);
					} else if (dados[5].equalsIgnoreCase(TipoConta.CONT_POU.getTipoConta())) {
						ContaPoupanca cp = new ContaPoupanca(dados[0], dados[1], dados[2], dados[3], dados[4], dados[5],
								dados[6], dados[7], dados[8]);
						String chaveOrdMap = dados[2] + dados[7];
						Conta.mapaContas.put(dados[7], cp);
						Conta.ordenaContas.put(chaveOrdMap, cp);
					} else if (dados[1].equalsIgnoreCase(TipoFuncionario.PRESIDENTE.getTipoFuncionario())) {
						Presidente presidente = new Presidente(dados[0], dados[1], dados[2], dados[3], dados[4],
								dados[5]);
						String chaveOrdMap = dados[2] + dados[3];
						Funcionario.mapaFuncionarios.put(dados[3], presidente);
						Funcionario.ordenaFuncionarios.put(chaveOrdMap, presidente);
					} else if (dados[1].equalsIgnoreCase(TipoFuncionario.DIRETOR.getTipoFuncionario())) {
						Diretor diretor = new Diretor(dados[0], dados[1], dados[2], dados[3], dados[4], dados[5],
								dados[6]);
						String chaveOrdMap = dados[2] + dados[3];
						Funcionario.mapaFuncionarios.put(dados[3], diretor);
						Funcionario.ordenaFuncionarios.put(chaveOrdMap, diretor);
					} else if (dados[1].equalsIgnoreCase(TipoFuncionario.GERENTE.getTipoFuncionario())) {
						Gerente gerente = new Gerente(dados[0], dados[1], dados[2], dados[3], dados[4], dados[5],
								dados[6]);
						String chaveOrdMap = dados[2] + dados[3];
						Funcionario.mapaFuncionarios.put(dados[3], gerente);
						Funcionario.ordenaFuncionarios.put(chaveOrdMap, gerente);
					} else if (dados[1].equalsIgnoreCase(TipoFuncionario.OPERADOR_CAIXA.getTipoFuncionario())) {
						OperadorCaixa caixa = new OperadorCaixa(dados[0], dados[1], dados[2], dados[3], dados[4],
								dados[5]);
						String chaveOrdMap = dados[2] + dados[3];
						Funcionario.mapaFuncionarios.put(dados[3], caixa);
						Funcionario.ordenaFuncionarios.put(chaveOrdMap, caixa);
					} else {
						break;
					}
				}
			}
		}
	}
}
