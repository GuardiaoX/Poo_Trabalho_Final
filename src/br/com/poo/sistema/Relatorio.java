package br.com.poo.sistema;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import br.com.poo.contas.Conta;

public abstract class Relatorio {
	static final String PATH_BASICO = ".\\Bernardo\\temp2\\";
	static final String EXTENSAO = ".txt";

	public static void comprovanteSaldo(Conta conta) throws IOException {
		String nomeArquivo = conta.getCpf() + "_" + conta.getAgencia() + "_saldo";
		try (BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nomeArquivo + EXTENSAO))) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();
			String linha = "===============================================";
			buffWrite.append(linha + "\n");
			linha = "COMPROVANTE DE SALDO";
			buffWrite.append(linha + "\n");
			linha = "===============================================";
			buffWrite.append(linha + "\n");
			linha = "Nome: " + conta.getNome();
			buffWrite.append(linha + "\n");
			linha = "CPF: " + conta.getCpf();
			buffWrite.append(linha + "\n");
			linha = "Agência: " + conta.getAgencia();
			buffWrite.append(linha + "\n");
			linha = "Conta: " + conta.getNumConta();
			buffWrite.append(linha + "\n");
			linha = "Saldo: " + conta.getSaldo();
			buffWrite.append(linha + "\n");
			linha = "Realizado em: " + sdf.format(date);
			buffWrite.append(linha + "\n");
			linha = "===============================================";
			buffWrite.append(linha + "\n");
		}
	}

	public static void comprovanteDep(Conta conta, BigDecimal valor) throws IOException {
		String nomeArquivo = conta.getCpf() + "_" + conta.getAgencia() + "_deposito";
		try (BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nomeArquivo + EXTENSAO))) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();
			String linha = "===============================================";
			buffWrite.append(linha + "\n");
			linha = "COMPROVANTE DE DEPÓSITO";
			buffWrite.append(linha + "\n");
			linha = "===============================================";
			buffWrite.append(linha + "\n");
			linha = "Nome: " + conta.getNome();
			buffWrite.append(linha + "\n");
			linha = "CPF: " + conta.getCpf();
			buffWrite.append(linha + "\n");
			linha = "Agência: " + conta.getAgencia();
			buffWrite.append(linha + "\n");
			linha = "Conta: " + conta.getNumConta();
			buffWrite.append(linha + "\n");
			linha = "Valor: R$ " + valor;
			buffWrite.append(linha + "\n");
			linha = "Realizado em: " + sdf.format(date);
			buffWrite.append(linha + "\n");
			linha = "===============================================";
			buffWrite.append(linha + "\n");
		}
	}

	public static void comprovanteSq(Conta conta, BigDecimal valor) throws IOException {
		String nomeArquivo = conta.getCpf() + "_" + conta.getAgencia() + "_saque";
		try (BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nomeArquivo + EXTENSAO))) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();
			String linha = "===============================================";
			buffWrite.append(linha + "\n");
			linha = "COMPROVANTE DE SAQUE";
			buffWrite.append(linha + "\n");
			linha = "===============================================";
			buffWrite.append(linha + "\n");
			linha = "Nome: " + conta.getNome();
			buffWrite.append(linha + "\n");
			linha = "CPF: " + conta.getCpf();
			buffWrite.append(linha + "\n");
			linha = "Agência: " + conta.getAgencia();
			buffWrite.append(linha + "\n");
			linha = "Conta: " + conta.getNumConta();
			buffWrite.append(linha + "\n");
			linha = "Valor: R$ " + valor;
			buffWrite.append(linha + "\n");
			linha = "Realizado em: " + sdf.format(date);
			buffWrite.append(linha + "\n");
			linha = "===============================================";
			buffWrite.append(linha + "\n");
		}
	}

	public static void comprovanteTransferencia(Conta remetente, Conta destinatario, BigDecimal valor)
			throws IOException {
		String nomeArquivo = remetente.getCpf() + "_" + remetente.getAgencia() + "_transferencia";
		try (BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nomeArquivo + EXTENSAO))) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();
			String linha = "===============================================";
			buffWrite.append(linha + "\n");
			linha = "COMPROVANTE DE TRANSFERÊNCIA";
			buffWrite.append(linha + "\n");
			linha = "===============================================";
			buffWrite.append(linha + "\n");
			linha = "Nome do remetente: " + remetente.getNome();
			buffWrite.append(linha + "\n");
			linha = "CPF do remetente: " + remetente.getCpf();
			buffWrite.append(linha + "\n");
			linha = "Agência do remetente: " + remetente.getAgencia();
			buffWrite.append(linha + "\n");
			linha = "Conta do remetente: " + remetente.getNumConta();
			buffWrite.append(linha + "\n");
			linha = "Nome do destinatario: " + destinatario.getNome();
			buffWrite.append(linha + "\n");
			linha = "CPF do destinatario: " + destinatario.getCpf();
			buffWrite.append(linha + "\n");
			linha = "Agência do destinatario: " + destinatario.getAgencia();
			buffWrite.append(linha + "\n");
			linha = "Conta do destinatario: " + destinatario.getNumConta();
			buffWrite.append(linha + "\n");
			linha = "Valor: " + valor;
			buffWrite.append(linha + "\n");
			linha = "Realizado em: " + sdf.format(date);
			buffWrite.append(linha + "\n");
			linha = "===============================================";
			buffWrite.append(linha + "\n");
		}
	}

	public static void comprovanteRendiAcumulado(Conta conta, BigDecimal rendiAcumulado) throws IOException {
		String nomeArquivo = conta.getCpf() + "_" + conta.getAgencia() + "_rendimento";
		try (BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nomeArquivo + EXTENSAO))) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();
			String linha = "===============================================";
			buffWrite.append(linha + "\n");
			linha = "              COMPROVANTE DE RENDIMENTO         ";
			buffWrite.append(linha + "\n");
			linha = "===============================================";
			buffWrite.append(linha + "\n");
			linha = "Conta: " + conta.getNumConta();
			buffWrite.append(linha + "\n");
			linha = "Titular: " + conta.getNome();
			buffWrite.append(linha + "\n");
			linha = "Rendimento Acumulado: R$" + rendiAcumulado;
			buffWrite.append(linha + "\n");
			linha = "Saldo: R$" + conta.getSaldo();
			buffWrite.append(linha + "\n");
			linha = "Realizado em: " + sdf.format(date);
			buffWrite.append(linha + "\n");
			linha = "===============================================";
			buffWrite.append(linha + "\n");
		}
	}

	public static void comprovanteRendiSobreSaldoSimulado(Conta conta, BigDecimal valor, long diferencaDias,
			BigDecimal rendiAcumuladoSimulado) throws IOException {
		String nomeArquivo = conta.getCpf() + "_" + conta.getAgencia() + "_rendimento_simulado";
		try (BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nomeArquivo + EXTENSAO))) {
			String linha = "===============================================";
			buffWrite.append(linha + "\n");
			linha = "          COMPROVANTE DE CÁLCULO DE RENDIMENTO          ";
			buffWrite.append(linha + "\n");
			linha = "===============================================";
			buffWrite.append(linha + "\n");
			linha = "Conta: " + conta.getNumConta();
			buffWrite.append(linha + "\n");
			linha = "Titular: " + conta.getNome();
			buffWrite.append(linha + "\n");
			linha = "Valor investido: R$" + valor;
			buffWrite.append(linha + "\n");
			linha = "Dias de rendimento: " + diferencaDias;
			buffWrite.append(linha + "\n");
			linha = "Rendimento: R$" + rendiAcumuladoSimulado;
			buffWrite.append(linha + "\n");
			linha = "Saldo após rendimento: R$" + (conta.getSaldo().add(rendiAcumuladoSimulado));
			buffWrite.append(linha + "\n");
			linha = "===============================================";
			buffWrite.append(linha + "\n");
		}
	}

//	public static void relatorioContasDaAgencia(String agencia) throws IOException {
//		String nomeArquivo = "relatorioContasDaAgencia_" + agencia;
//		try (BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nomeArquivo + EXTENSAO))) {
//			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//			Date date = new Date();
//			String linha = "===============================================";
//			buffWrite.append(linha + "\n");
//			linha = "       RELATÓRIO DE CONTAS DA AGÊNCIA " + agencia + "       ";
//			buffWrite.append(linha + "\n");
//			linha = "===============================================";
//			buffWrite.append(linha + "\n\n");
//			for (Conta conta : Conta.mapaContas.values()) {
//				if (conta.getAgencia().equals(agencia)) {
//					linha = "Conta: " + conta.getNumConta();
//					buffWrite.append(linha + "\n");
//					linha = "Titular: " + conta.getNome();
//					buffWrite.append(linha + "\n");
//					linha = "Saldo: R$ " + conta.getSaldo();
//					buffWrite.append(linha + "\n\n");
//				}
//			}
//			linha = "Realizado em: " + sdf.format(date);
//			buffWrite.append(linha + "\n");
//			linha = "===============================================";
//			buffWrite.append(linha + "\n");
//		}
//	}

	public static void relatorioClientesDoBanco() throws IOException {
		String nomeArquivo = "relatorioClientesDoBanco";
		try (BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nomeArquivo + EXTENSAO))) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();
			String linha = "===============================================";
			buffWrite.append(linha + "\n");
			linha = "          RELATÓRIO DE CLIENTES DO BANCO       ";
			buffWrite.append(linha + "\n");
			linha = "===============================================";
			buffWrite.append(linha + "\n\n");
			for (Conta conta : Conta.ordenaContas.values()) {
				linha = "Conta: " + conta.getNumConta();
				buffWrite.append(linha + "\n");
				linha = "Titular: " + conta.getNome();
				buffWrite.append(linha + "\n");
				linha = "Agência: " + conta.getAgencia();
				buffWrite.append(linha + "\n");
				linha = "Saldo: R$" + conta.getSaldo();
				buffWrite.append(linha + "\n\n");
			}
			linha = "Realizado em: " + sdf.format(date);
			buffWrite.append(linha + "\n");
			;
			linha = "===============================================";
			buffWrite.append(linha + "\n");
		}
	}

	public static void relatorioCapitalDoBanco() throws IOException {
		String nomeArquivo = "relatorioCapitalDoBanco";
		BigDecimal valor = new BigDecimal("0.00");

		try (BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nomeArquivo + EXTENSAO))) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();
			String linha = "===============================================";
			buffWrite.append(linha + "\n");
			linha = "            RELATÓRIO DE CAPITAL DO BANCO            ";
			buffWrite.append(linha + "\n");
			linha = "===============================================";
			buffWrite.append(linha + "\n\n");

			for (Map.Entry<String, Conta> entrada : Conta.mapaContas.entrySet()) {
				linha = "Conta: " + entrada.getValue().getNumConta();
				buffWrite.append(linha + "\n");
				linha = "Titular: " + entrada.getValue().getNome();
				buffWrite.append(linha + "\n");
				linha = "Saldo: R$ " + entrada.getValue().getSaldo();
				buffWrite.append(linha + "\n\n");
				valor = valor.add(entrada.getValue().getSaldo());
			}

			linha = "===============================================";
			buffWrite.append(linha + "\n");
			linha = "Capital total do Banco: R$ " + valor;
			buffWrite.append(linha + "\n");
			linha = "Realizado em: " + sdf.format(date);
			buffWrite.append(linha + "\n");
			linha = "===============================================";
			buffWrite.append(linha + "\n");
		}
	}

	public static void relatorioContasDaAgencia(String agencia) throws IOException {
		String nomeArquivo = "relatorioContasAgencia" + agencia;

		try (BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nomeArquivo + EXTENSAO))) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();
			String linha = "===============================================";
			buffWrite.append(linha + "\n");
			linha = "            RELATÓRIO DE CONTAS DA AGÊNCIA " + agencia + "           ";
			buffWrite.append(linha + "\n");
			linha = "===============================================";
			buffWrite.append(linha + "\n\n");
			// Laço de repetição para imprimir as contas da agência
			for (Conta conta : Conta.mapaContas.values()) {
				if (conta.getAgencia().equals(agencia)) {
					linha = "Conta: " + conta.getNumConta();
					buffWrite.append(linha + "\n");
					linha = "Titular: " + conta.getNome();
					buffWrite.append(linha + "\n");
					linha = "Saldo: R$ " + conta.getSaldo();
					buffWrite.append(linha + "\n\n");
				}
			}
			linha = "===============================================";
			buffWrite.append(linha + "\n");
			linha = "Realizado em: " + sdf.format(new Date());
			buffWrite.append(linha + "\n");
			linha = "===============================================";
			buffWrite.append(linha + "\n");
		}
	}
}
