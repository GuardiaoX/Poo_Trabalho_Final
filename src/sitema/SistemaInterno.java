package sitema;

import java.math.BigDecimal;
import java.util.Scanner;

import javax.swing.JOptionPane;

import cargos.Funcionario;
import cargos.Gerente;
import contas.Conta;
import contas.ContaCorrente;
import contas.ContaPoupanca;

public class SistemaInterno {
	public static void main(String[] args) {
//		Funcionario daniel = new Gerente("Daniel", "1234", "4321");
//
//		if (JOptionPane.showInputDialog("CPF").equals(daniel.getCpf())
//				& JOptionPane.showInputDialog("Senha").equals(daniel.getSenha())) {
//			JOptionPane.showMessageDialog(null,
//					("Olá " + daniel.getNome() + "\n Qual função deseja acessar:\n1-Saldo\n2-Sacar\n3-Depositar"));
//		} else {
//			JOptionPane.showMessageDialog(null,
//					("Olá " + daniel.getNome() + ", você esqueceu que sua senha era " + daniel.getSenha()));
//		}
		String valor;
		String valor2;
		String valor3;
		String valor4;
		Scanner sc = new Scanner(System.in);
		ContaCorrente mcZezin = new ContaCorrente();
		ContaPoupanca donaJoana = new ContaPoupanca();
		System.out.print("Valor para depósito: ");
		valor = sc.nextLine();
		if (mcZezin.verificaEntrada(new BigDecimal(valor))) {
			mcZezin.deposito(new BigDecimal(valor));
			System.out.print("\nValor para transferência: ");
			valor2 = sc.nextLine();
			if (mcZezin.verificaEntrada(new BigDecimal(valor2))) {
				mcZezin.transferencia(donaJoana, new BigDecimal(valor2));
				System.out.print("\nValor para transferência: ");
				valor3 = sc.nextLine();
				if (mcZezin.verificaEntrada(new BigDecimal(valor3))) {
					mcZezin.transferencia(donaJoana, new BigDecimal(valor3));
					System.out.print("\nValor para saque: ");
					valor4 = sc.nextLine();
					if (mcZezin.verificaEntrada(new BigDecimal(valor4))) {
						mcZezin.saque(new BigDecimal(valor4));
						System.out.print(mcZezin.getSaldo() + "\n");
								
						//donaJoana.rendiSobreSaldo();
						System.out.print(donaJoana.getSaldo());
						//System.out.print("\n"+((ContaPoupanca) donaJoana).getRendiAcumulado());
						mcZezin.tributacaoAcumuladoCalculo();
						System.out.print("\n"+mcZezin.getTribGeralAcumu());
						sc.close();
					}
				}
			}
		}
	}
}
