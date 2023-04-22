package contas;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.poo.enums.conta.TipoOperacao;
import br.com.poo.enums.conta.TributacaoTipo;
import br.com.poo.enums.conta.TipoConta;

public class ContaPoupanca extends Conta {
	private String tipoConta;
	private int tipoContaId;
	private BigDecimal rendiTaxaAnual = new BigDecimal("14.6"); // OBS: Porcento(%)
	private BigDecimal rendiTaxaDiario = new BigDecimal("0.0004"); // OBS: Porcento(%)
	private BigDecimal rendiDiario = new BigDecimal("0.00");
	private BigDecimal rendiAcumulado = new BigDecimal("0.00");

	public ContaPoupanca() {
		tipoConta = TipoConta.CONT_POU.getTipoConta();
		tipoContaId = TipoConta.CONT_POU.getId();
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public int getTipoContaId() {
		return tipoContaId;
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
		if (getSaldo().compareTo(getParamZero()) == 1) {
			rendiDiario = getSaldo().multiply(rendiTaxaDiario);
			deposito(rendiDiario);
			rendiAcumulado = rendiAcumulado.add(rendiDiario);
			return true;
		} else {
			return false;
		}
	}

//	public BigDecimal rendiSobreSaldoSimulado(BigDecimal valor, int fimDia, int fimMes, int fimAno) {
//		LocalDate inicio = new LocalDate.now();
//		int inicioDia = 
//		
//		
//		
//		
//		return valor;
//	}
}









