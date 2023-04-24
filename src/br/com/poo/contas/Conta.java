package br.com.poo.contas;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import br.com.poo.cargos.Cliente;
import br.com.poo.enums.TipoOperacao;
import br.com.poo.enums.TributacaoTipo;

public abstract class Conta extends Cliente {
	private String tipoConta;
	private String agencia;
	private String numConta;
	private BigDecimal saldo = new BigDecimal("0.00");
	private BigDecimal taxaDep = new BigDecimal("0.10");
	private BigDecimal taxaSq = new BigDecimal("0.10");
	private BigDecimal taxaTransf = new BigDecimal("0.20");
	private BigDecimal minDep = new BigDecimal("1.00"); // Mínimo para depósito 10*taxaDep
	private final BigDecimal paramZero = new BigDecimal("0.00");
	private final BigDecimal paramUm = new BigDecimal("1.00");
	private BigDecimal totalDep = new BigDecimal("0.00");
	private BigDecimal totalSq = new BigDecimal("0.00");
	private BigDecimal totalTransf = new BigDecimal("0.00");
	private BigDecimal tribDepAcumu = new BigDecimal("0.00");
	private BigDecimal tribSqAcumu = new BigDecimal("0.00");
	private BigDecimal tribTransfAcumu = new BigDecimal("0.00");
	private BigDecimal tribGeralAcumu = new BigDecimal("0.00");

	public static Map<String, Conta> mapaContas = new HashMap<>();
	public static TreeMap<String, Conta> ordenaContas = new TreeMap<>();
	
	 
	public Conta() {
	}

	public Conta(String tipoPessoa, String tipoCliente, String nome, String cpf, String senha, String tipoConta, String agencia,
			String numConta, String saldo) {
		super(tipoPessoa, tipoCliente, nome, cpf, senha);
		this.tipoConta = tipoConta;
		this.agencia = agencia;
		this.numConta = numConta;
		this.saldo = new BigDecimal(saldo);
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public String getAgencia() {
		return agencia;
	}

	public String getNumConta() {
		return numConta;
	}

	public BigDecimal getTaxaDep() {
		return taxaDep;
	}

	public void setTaxaDep(BigDecimal taxaDep) {
		this.taxaDep = taxaDep;
	}

	public BigDecimal getTaxaSq() {
		return taxaSq;
	}

	public void setTaxaSq(BigDecimal taxaSq) {
		this.taxaSq = taxaSq;
	}

	public BigDecimal getTaxaTransf() {
		return taxaTransf;
	}

	public void setTaxaTransf(BigDecimal taxaTransf) {
		this.taxaTransf = taxaTransf;
	}

	public BigDecimal getMinDep() {
		return minDep;
	}

	public void setMinDep(BigDecimal minDep) {
		this.minDep = minDep;
	}

	public BigDecimal getTotalDep() {
		return totalDep;
	}

	public void setTotalDep(BigDecimal totalDep) {
		this.totalDep = totalDep;
	}

	public BigDecimal getTotalSq() {
		return totalSq;
	}

	public void setTotalSq(BigDecimal totalSq) {
		this.totalSq = totalSq;
	}

	public BigDecimal getTotalTransf() {
		return totalTransf;
	}

	public void setTotalTransf(BigDecimal totalTransf) {
		this.totalTransf = totalTransf;
	}

	public BigDecimal getTribDepAcumu() {
		return tribDepAcumu;
	}

	public void setTribDepAcumu(BigDecimal tribDepAcumu) {
		this.tribDepAcumu = tribDepAcumu;
	}

	public BigDecimal getTribSqAcumu() {
		return tribSqAcumu;
	}

	public void setTribSqAcumu(BigDecimal tribSqAcumu) {
		this.tribSqAcumu = tribSqAcumu;
	}

	public BigDecimal getTribTransfAcumu() {
		return tribTransfAcumu;
	}

	public void setTribTransfAcumu(BigDecimal tribTransfAcumu) {
		this.tribTransfAcumu = tribTransfAcumu;
	}

	public BigDecimal getTribGeralAcumu() {
		return tribGeralAcumu;
	}

	public void setTribGeralAcumu(BigDecimal tribGeralAcumu) {
		this.tribGeralAcumu = tribGeralAcumu;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public BigDecimal getParamZero() {
		return paramZero;
	}

	public BigDecimal getParamUm() {
		return paramUm;
	}

	public Boolean deposito(BigDecimal valor) {
		this.saldo = this.saldo.add(valor);
		this.totalDep = this.totalDep.add(paramUm);
		return true;
	}

	public Boolean saque(BigDecimal valor) {
		this.saldo = this.saldo.subtract(valor);
		this.totalSq = this.totalSq.add(paramUm);
		return true;
	}

	public Boolean transferencia(Conta dest, BigDecimal valor) {
		this.saldo = this.saldo.subtract(valor);
		this.totalTransf = this.totalTransf.add(paramUm);
		dest.saldo = dest.saldo.add(valor);
		return true;
	}

	public Boolean verificaSaldo(BigDecimal valor, int tipoOperacao, int tributacaoTipo) {
		if (tributacaoTipo == TributacaoTipo.TRIB_PAD.getId()) {
			if (tipoOperacao == 1) {
				if (valor.compareTo(minDep) == 0 | valor.compareTo(minDep) == 1) {
					return true;
				} else {
					return false;
				}
			} else if (tipoOperacao == 2) {
				valor = valor.add(taxaSq);
				return compareToVeriSal(valor);
			} else if (tipoOperacao == 3) {
				valor = valor.add(taxaTransf);
				return compareToVeriSal(valor);
			} else {
				return false;
			}
		} else if (tributacaoTipo == TributacaoTipo.TRIB_INSENTO.getId()) {
			if (tipoOperacao == 1) {
				return true;
			} else if (tipoOperacao == 2) {
				return compareToVeriSal(valor);
			} else if (tipoOperacao == 3) {
				return compareToVeriSal(valor);
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public Boolean compareToVeriSal(BigDecimal valor) {
		int paramCompareTo = this.saldo.compareTo(valor);
		if (paramCompareTo > 0) {
			return true;
		} else if (paramCompareTo < 0) {
			return false;
		} else {
			return true;
		}
	}

	public Boolean verificaEntrada(BigDecimal valor) {
		if (valor.compareTo(paramZero) > 0 || valor.compareTo(paramZero) == 0) {
			BigDecimal valor1 = valor.multiply(new BigDecimal(100));
			Integer valor2 = valor1.intValue();
			BigDecimal valor3 = new BigDecimal(valor2);
			if ((valor1.subtract(valor3)) == (valor1.subtract(valor1))) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public Boolean tributacaoConta(int tipoOperacao, int tributacaoTipoId) {
		if (tributacaoTipoId == TributacaoTipo.TRIB_PAD.getId()) {
			if (tipoOperacao == TipoOperacao.DEP.getId()) {
				this.saldo = this.saldo.subtract(taxaDep);
				return true;
			} else if (tipoOperacao == TipoOperacao.SQ.getId()) {
				this.saldo = this.saldo.subtract(taxaSq);
				return true;
			} else if (tipoOperacao == TipoOperacao.TRANSF.getId()) {
				this.saldo = this.saldo.subtract(taxaTransf);
				return true;
			} else {
				return false;
			}
		} else if (tributacaoTipoId == TributacaoTipo.TRIB_INSENTO.getId()) {
			return true;
		} else {
			return false;
		}
	}

	public Boolean tributacaoAcumuladoCalculo() {
		if (TributacaoTipo.TRIB_PAD.getId() == 1) {
			BigDecimal paramTribDep;
			BigDecimal paramTribSq;
			BigDecimal paramTribTransf;
			BigDecimal paramTribGeral;
			paramTribDep = totalDep.multiply(taxaDep);
			tribDepAcumu = tribDepAcumu.add(paramTribDep);
			paramTribSq = totalSq.multiply(taxaSq);
			tribSqAcumu = tribSqAcumu.add(paramTribSq);
			paramTribTransf = totalTransf.multiply(taxaTransf);
			tribTransfAcumu = tribTransfAcumu.add(paramTribTransf);
			paramTribGeral = tribDepAcumu.add(tribSqAcumu);
			paramTribGeral = paramTribGeral.add(tribTransfAcumu);
			tribGeralAcumu = tribGeralAcumu.add(paramTribGeral);
			return true;
		} else if (TributacaoTipo.TRIB_PAD.getId() == 2) {
			return true;
		} else {
			return false;
		}
	}
	
	public static Boolean loginConta(String cpf, String senha) {
		String cpf2 = cpf;

		return false;
	}
}









