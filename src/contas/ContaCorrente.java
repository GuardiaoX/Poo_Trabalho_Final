package contas;

import java.math.BigDecimal;

import br.com.poo.enums.conta.TipoOperacao;
import br.com.poo.enums.conta.TributacaoTipo;
import br.com.poo.enums.conta.TipoConta;

public class ContaCorrente extends Conta {
	private String tipoConta;
	private int tipoContaId;

	public ContaCorrente() {
		tipoConta = TipoConta.CONT_CORR.getTipoConta();
		tipoContaId = TipoConta.CONT_CORR.getId();
	}

	public String tipoConta() {
		return tipoConta;
	}

	public int tipoContaId() {
		return tipoContaId;
	}

	@Override
	public Boolean deposito(BigDecimal valor) {
		Boolean paramVerificaSaldo = verificaSaldo(valor, TipoOperacao.DEP.getId(), TributacaoTipo.TRIB_PAD.getId());
		if (paramVerificaSaldo) {
			tributacaoConta(TipoOperacao.DEP.getId(), TributacaoTipo.TRIB_PAD.getId());
			return super.deposito(valor);
		} else {
			return false;
		}
	}

	@Override
	public Boolean saque(BigDecimal valor) {
		Boolean paramVerificaSaldo = verificaSaldo(valor, TipoOperacao.SQ.getId(), TributacaoTipo.TRIB_PAD.getId());
		if (paramVerificaSaldo) {
			tributacaoConta(TipoOperacao.SQ.getId(), TributacaoTipo.TRIB_PAD.getId());
			return super.saque(valor);
		} else {
			return false;
		}
	}

	@Override
	public Boolean transferencia(Conta dest, BigDecimal valor) {
		Boolean paramVerificaSaldo = verificaSaldo(valor, TipoOperacao.TRANSF.getId(), TributacaoTipo.TRIB_PAD.getId());
		if (paramVerificaSaldo) {
			tributacaoConta(TipoOperacao.TRANSF.getId(), TributacaoTipo.TRIB_PAD.getId());
			return super.transferencia(dest, valor);
		} else {
			return false;
		}
	}
}
