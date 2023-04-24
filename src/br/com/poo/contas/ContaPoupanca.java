package br.com.poo.contas;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import br.com.poo.enums.TipoOperacao;
import br.com.poo.enums.TributacaoTipo;

public class ContaPoupanca extends Conta {
	private BigDecimal rendiTaxaAnual = new BigDecimal("14.6"); // OBS: Porcento(%)
	private BigDecimal rendiTaxaDiario = new BigDecimal("0.0004"); // OBS: Porcento(%)
	private BigDecimal rendiDiario = new BigDecimal("0.00");
	private BigDecimal rendiAcumulado = new BigDecimal("0.00");

	public ContaPoupanca() {
	}

	public ContaPoupanca(String tipoPessoa, String tipoCliente, String nome, String cpf, String senha, String tipoConta, String agencia,
			String numConta, String saldo) {
		super(tipoPessoa, tipoCliente, nome, cpf, senha, tipoConta, agencia, numConta, saldo);
	}

	public BigDecimal getRendiTaxaAnual() {
		return rendiTaxaAnual;
	}

	public void setRendiTaxaAnual(BigDecimal rendiTaxaAnual) {
		this.rendiTaxaAnual = rendiTaxaAnual;
	}

	public BigDecimal getRendiTaxaDiario() {
		return rendiTaxaDiario;
	}

	public void setRendiTaxaDiario(BigDecimal rendiTaxaDiario) {
		this.rendiTaxaDiario = rendiTaxaDiario;
	}

	public BigDecimal getRendiDiario() {
		return rendiDiario;
	}

	public BigDecimal getRendiAcumulado() {
		return rendiAcumulado;
	}

	public void setRendiAcumulado(BigDecimal rendiAcumulado) {
		this.rendiAcumulado = rendiAcumulado;
	}

	@Override
	public Boolean deposito(BigDecimal valor) {
		Boolean paramVerificaSaldo = verificaSaldo(valor, TipoOperacao.DEP.getId(),
				TributacaoTipo.TRIB_INSENTO.getId());
		if (paramVerificaSaldo) {
			tributacaoConta(TipoOperacao.DEP.getId(), TributacaoTipo.TRIB_INSENTO.getId());
			return super.deposito(valor);
		} else {
			return false;
		}
	}

	@Override
	public Boolean saque(BigDecimal valor) {
		Boolean paramVerificaSaldo = verificaSaldo(valor, TipoOperacao.SQ.getId(), TributacaoTipo.TRIB_INSENTO.getId());
		if (paramVerificaSaldo) {
			tributacaoConta(TipoOperacao.SQ.getId(), TributacaoTipo.TRIB_INSENTO.getId());
			return super.saque(valor);

		} else {
			return false;
		}

	}

	@Override
	public Boolean transferencia(Conta dest, BigDecimal valor) {
		Boolean paramVerificaSaldo = verificaSaldo(valor, TipoOperacao.TRANSF.getId(),
				TributacaoTipo.TRIB_INSENTO.getId());
		if (paramVerificaSaldo) {
			tributacaoConta(TipoOperacao.TRANSF.getId(), TributacaoTipo.TRIB_INSENTO.getId());
			return super.transferencia(dest, valor);
		} else {
			return false;
		}
	}

	public Boolean rendiSobreSaldo() {
		if (getSaldo().compareTo(getParamZero()) > 0) {
			rendiDiario = getSaldo().multiply(rendiTaxaDiario);
			deposito(rendiDiario);
			rendiAcumulado = rendiAcumulado.add(rendiDiario);
			return true;
		} else {
			return false;
		}
	}

	public BigDecimal rendiSobreSaldoSimulado(BigDecimal valor, int fimDia, int fimMes, int fimAno) {
		BigDecimal rendiAcumuladoSimulado;
		LocalDate inicio = LocalDate.now();
		LocalDate fim = LocalDate.of(fimAno, fimMes, fimDia);
		long diferencaDias = ChronoUnit.DAYS.between(inicio, fim);
		rendiAcumuladoSimulado = rendiTaxaDiario.multiply(valor);
		rendiAcumuladoSimulado = rendiAcumuladoSimulado.multiply(new BigDecimal(diferencaDias));
		rendiAcumuladoSimulado = valor.add(rendiAcumuladoSimulado);
		return rendiAcumuladoSimulado;
	}
}
