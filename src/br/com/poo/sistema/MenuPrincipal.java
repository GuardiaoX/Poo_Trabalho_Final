package br.com.poo.sistema;

import java.io.IOException;
import java.util.Map;

import br.com.poo.contas.Conta;
import br.com.poo.contas.ContaCorrente;
import br.com.poo.contas.ContaPoupanca;
import br.com.poo.cargos.Cliente;
import br.com.poo.cargos.Funcionario;
import br.com.poo.cargos.Gerente;

public class MenuPrincipal {

	public static void menuPrincipalFunc(Funcionario func) throws IOException {
		MenuInterativo menuInterativo = new MenuInterativo();
		HomePage homePage = new HomePage();
		
		while (true) {
			menuInterativo.imprimeLinhaHorizontal();
			System.out.println("=============Painel===============");
			System.out.println("[1]\tRelatórios\n");
			System.out.println("[2]\tBonificação\n");
			System.out.println("[0]\tRetonar");
			System.out.println("Digite a opção desejada: ");
			int opc = MenuInterativo.sc.nextInt();

			switch (opc) {
			case 1:
				relatoriosOpcoes(func);
				break;
			case 2:
				bonificacaoOpcoes(func);
				break;
			case 0:
				Wait.aguarde(2000);
				menuInterativo.limpaTela();
				homePage.login();
			default:
				break;
			}
		}
	}

	private static void relatoriosOpcoes(Funcionario func) throws IOException {
		if (func.getTipoFuncionario().equalsIgnoreCase("caixa")) {
			System.out.println("\nOpção disponível apenas para Gerentes, Diretores e Presidente.");
			return;
		}

		MenuInterativo menuInterativo = new MenuInterativo();
		System.out.println("\n=========Relatório=========");
		System.out.println("[1]\tRelatório de Contas da Agência\n");
		System.out.println("[2]\tRelatório dos Clientes do Banco\n");
		System.out.println("[3]\tRelatório de Capital do Banco");
		System.out.println("[0]\tRetornar ao Menu");

		menuInterativo.imprimeLinhaHorizontal();

		System.out.println("Digite a opção desejada: ");
		int opc1 = MenuInterativo.sc.nextInt();

		switch (opc1) {
		case 1:
			relatorioContasDaAgencia(func);
			break;
		case 2:
			relatorioClientesDoBanco(func);
			break;
		case 3:
			relatorioCapitalDoBanco(func);
			break;
		case 0:
			Wait.aguarde(2000);
			menuInterativo.limpaTela();
			menuPrincipalFunc(func);
			
		default:
			break;
		}
	}

	private static void relatorioContasDaAgencia(Funcionario func) throws IOException {
		if (func.getTipoFuncionario().equalsIgnoreCase("gerente")) {
			// Código para imprimir relatório de contas da agência
			String agencia = ((Gerente) func).getAgenciaResp();
			for (Conta conta : Conta.mapaContas.values()) {
				if (conta.getAgencia().equals(agencia)) {
					System.out.println(conta);
					LeituraEscrita.relatorioContasDaAgencia(agencia);
					Wait.aguarde(500);
				}
			}

		} else if (func.getTipoFuncionario().equalsIgnoreCase("diretor")
				|| func.getTipoFuncionario().equalsIgnoreCase("presidente")) {
			// Código para imprimir relatório de contas da agência
			for (Conta conta : Conta.mapaContas.values()) {
				System.out.println(conta);
				Wait.aguarde(500);
			}
			Wait.aguarde(700);

		}
	}

	private static void relatorioClientesDoBanco(Funcionario func) throws IOException {
		if (func.getTipoFuncionario().equalsIgnoreCase("gerente")) {
			System.out.println("\nOpção disponível apenas para Diretores e Presidente.");
			Wait.aguarde(3000);

		} else if (func.getTipoFuncionario().equalsIgnoreCase("diretor")
				|| func.getTipoFuncionario().equalsIgnoreCase("presidente")) {
			// Código para imprimir relatório dos clientes do banco

			for (Conta conta : Conta.ordenaContas.values()) {
			    System.out.println(conta + " - Saldo: " + conta.getSaldo());
			    LeituraEscrita.relatorioClientesDoBanco();
			}
			Wait.aguarde(3000);
		}
	}

	private static void relatorioCapitalDoBanco(Funcionario func) throws IOException {
		if (func.getTipoFuncionario().equalsIgnoreCase("gerente")
				|| func.getTipoFuncionario().equalsIgnoreCase("diretor")) {

			System.out.println("Opção disponível apenas para o Presidente.");
			Wait.aguarde(3000);

		} else if (func.getTipoFuncionario().equalsIgnoreCase("presidente")) {
			double saldoTotal = 0;
			for (Map.Entry<String, Conta> entrada : Conta.mapaContas.entrySet()) {
				saldoTotal += entrada.getValue().getSaldo();
			}
			System.out.println("A capital total do Banco é: " + saldoTotal);
			LeituraEscrita.relatorioCapitalDoBanco(saldoTotal);
			Wait.aguarde(3000);
		}
	}

	private static void bonificacaoOpcoes(Funcionario func) {
		if (func.getTipoFuncionario().equalsIgnoreCase("caixa")) {
			System.out.printf("Sua bonificação é de 10%% do seu salário de R$%.2f é R$%.2f.", func.getSalario(),
					func.getSalario() * 0.10);
			System.out.println("\n");
			Wait.aguarde(2000);
		}
		if (func.getTipoFuncionario().equalsIgnoreCase("gerente")) {
			System.out.printf("Sua bonificação é de 20%% do seu salário de R$%.2f é R$%.2f.", func.getSalario(),
					func.getSalario() * 0.20);
			System.out.println("\n");
			Wait.aguarde(2000);

		}
		if (func.getTipoFuncionario().equalsIgnoreCase("diretor")) {
			System.out.printf("Sua bonificação é 30%% do seu salário de R$%.2f é R$%.2f.", func.getSalario(),
					func.getSalario() * 0.30);
			System.out.println("\n");
			Wait.aguarde(2000);
		}
		if (func.getTipoFuncionario().equalsIgnoreCase("presidente")) {
			System.out.println("Compre um sítio no nome do seu amigo" + "\n");
			System.out.println("\n");
			Wait.aguarde(2000);
		}

	}

	public static void menuPrincipal(Cliente cliente, Conta conta) throws IOException {

		int escolha, dias;
		Double rendimentoTotal, value, inputValor, rendimento;
		MenuInterativo menuInterativo = new MenuInterativo();

		while (true) {
			System.out.println("\n=========Menu========");
			System.out.println("[1]\tSaque");
			System.out.println("[2]\tDepósito");
			System.out.println("[3]\tTransferência");
			System.out.println("[4]\tSaldo");
			System.out.println("[5]\tRelatório");
			System.out.println("[0]\tSair");
			menuInterativo.imprimeLinhaHorizontal();
			System.out.println("Digite a opção desejada: ");

			int opc = MenuInterativo.sc.nextInt();

			if (conta.getTipoConta().equalsIgnoreCase("poupanca")) {
				switch (opc) {
				case 1:
					System.out.println("Digite o valor que deseja sacar: \n");
					inputValor = MenuInterativo.sc.nextDouble();
					LeituraEscrita.comprovanteSaque(conta, inputValor);
					conta.sacar(inputValor);
					Wait.aguarde(2000);
					menuInterativo.limpaTela();
					break;
				case 2:
					System.out.println("Digite o valor que deseja Depositar: \n");
					inputValor = MenuInterativo.sc.nextDouble();
					conta.depositar(inputValor + conta.getSaldo());
					LeituraEscrita.comprovanteDeposito(conta, inputValor);		
					Wait.aguarde(2000);
					menuInterativo.limpaTela();
					break;
				case 3:
					// código para transferência
					
					
					
					
					
					break;
				case 4:
					System.out.println("=============SALDO============\n");
					System.out.println("Seu saldo é" + conta.getSaldo());
					LeituraEscrita.comprovanteSaldo(conta);
					Wait.aguarde(2000);
					menuInterativo.limpaTela();
					break;
				case 5:
					do {
						menuInterativo.imprimeLinhaHorizontal();
						System.out.println("Relatórios Desejados:\n");
						System.out.println("Relatório de Rendimento com Saldo Atual(1)\n");
						System.out.println("Calcular rendimento(2)\n");
						System.out.println("Qual relatório deseja?\n");
						escolha = MenuInterativo.sc.nextInt();
						Wait.aguarde(2000);
						menuInterativo.limpaTela();
					} while (escolha < 0 || escolha > 2);
					if (escolha == 1) {
						menuInterativo.imprimeLinhaHorizontal();
						System.out.println("=============Relatório de Rendimento=============\n");
						rendimentoTotal = conta.getSaldo() * 0.05;
						System.out.printf("O rendimento mensal de R$ %.2f é R$ %.2f\n", conta.getSaldo(),
								rendimentoTotal);
						LeituraEscrita.comprovanteRendimento(conta, rendimentoTotal);
						menuInterativo.imprimeLinhaHorizontal();
						Wait.aguarde(3000);
						menuInterativo.limpaTela();
					} else {
						menuInterativo.imprimeLinhaHorizontal();
						System.out.println("=============Calcular Rendimento=============\n");
						System.out.println("Qual o valor que deseja render?\n");
						value = MenuInterativo.sc.nextDouble();
						System.out.println("Quantos dias de rendimento?\n");
						dias = MenuInterativo.sc.nextInt();
						rendimento = ContaPoupanca.previsaoRendimento(value, dias);
						System.out.printf("O valor do rendimento de R$ %.2f por %d dias é R$ %.2f\n", value, dias,
								rendimento);
						LeituraEscrita.comprovanteCalculoRendimento(conta, value, dias, rendimento);
						Wait.aguarde(2000);
						menuInterativo.limpaTela();
						break;
					}

				case 0:
					return;

				default:

					System.out.println("Opção inválida! Tente novamente.");
					Wait.aguarde(2000);
					menuInterativo.limpaTela();

				}
			} else {
				switch (opc) {
				case 1:
					menuInterativo.imprimeLinhaHorizontal();
					System.out.println("Digite o valor que deseja sacar: ");

					inputValor = MenuInterativo.sc.nextDouble();

					conta.sacar(inputValor);

					LeituraEscrita.comprovanteSaque(conta, inputValor);
					Wait.aguarde(2000);
					menuInterativo.limpaTela();

					break;
				case 2:
					menuInterativo.imprimeLinhaHorizontal();
					System.out.println("Digite o valor que deseja depositar: ");

					inputValor = MenuInterativo.sc.nextDouble();

					conta.depositar(inputValor);

					LeituraEscrita.comprovanteDeposito(conta, inputValor);
					Wait.aguarde(2000);
					menuInterativo.limpaTela();

					break;

				case 3:
					
					
					

					break;
				case 4:
					System.out.println("=============SALDO============\n");
					System.out.println("Seu saldo é" + conta.getSaldo());
					LeituraEscrita.comprovanteSaldo(conta);
					Wait.aguarde(2000);
					menuInterativo.limpaTela();
					break;
				case 5:
					Wait.aguarde(2000);
					do {
						menuInterativo.imprimeLinhaHorizontal();
						System.out.println("Relatórios Desejados:\n");
						System.out.println("=============Relatório de Tributação(1)=============\n");
						System.out.println("Qual relatório deseja?\n");
						escolha = MenuInterativo.sc.nextInt();
						Wait.aguarde(2000);
						menuInterativo.limpaTela();
					} while (escolha != 1);

					if (escolha == 1) {
						menuInterativo.imprimeLinhaHorizontal();
						ContaCorrente cc = new ContaCorrente();
						System.out.println("Total de saques feitos: " + cc.getTotalSaques());
						System.out.println("Total de depósitos feitos: " + cc.getTotalDeposito());
						System.out.println("Total de transferências feitas: " + cc.getTotalTransferencia());
						menuInterativo.imprimeLinhaHorizontal();
						Wait.aguarde(2000);
						menuInterativo.limpaTela();
					} else {
						System.out.println("=============Opção Inválida!=============");
						Wait.aguarde(2000);
						menuInterativo.limpaTela();
					}
					break;

				case 0:
					return;

				default:
					System.out.println("Opção inválida! Tente novamente.");
					Wait.aguarde(2000);
					menuInterativo.limpaTela();
				}
			}

		}
	}
}