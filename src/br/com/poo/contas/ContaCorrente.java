package br.com.poo.contas;

import java.math.BigDecimal;

import br.com.poo.enums.TipoOperacao;
import br.com.poo.enums.TributacaoTipo;

public class ContaCorrente extends Conta {

	public ContaCorrente() {
	}

	public ContaCorrente(String tipoPessoa, String tipoCliente, String nome, String cpf, String senha, String tipoConta, String agencia,
			String numConta, String saldo) {
		super(tipoPessoa, tipoCliente, nome, cpf, senha, tipoConta, agencia, numConta, saldo);
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
