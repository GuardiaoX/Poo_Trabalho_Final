//package br.com.poo.sistema;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.Map;
//
//import javax.management.relation.RelationServiceNotRegisteredException;
//import javax.swing.JOptionPane;
//
//import br.com.poo.cargos.Pessoa;
//
//public class EscritaLeitura {
//
//	static final String PATH_BASICO = "./temp/";
//	static final String EXTENSAO = ".txt";
//
//	public static String leitor(String path) throws IOException {
//		BufferedReader buffRead = new BufferedReader(new FileReader(PATH_BASICO + path + EXTENSAO));
//		String linha = "";
//		String tudo = null;
//		while (true) {
//			linha = buffRead.readLine();
//			if (linha == (null)) {
//				break;
//			}else {
//				tudo += linha + "\n";
//			}
//		}
//		buffRead.close();
//		return tudo;
//	}
//
//	public static void escritor(String nome, String linha) throws IOException {
//
//		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nome + EXTENSAO, true));
//
//		buffWrite.append(linha + "\n");
//		buffWrite.close();
//
//	}
//
//	public static void main(String[] args) throws IOException {
//		String relatorio = null;
//		leitor("RelatorioPessoa");
//		
// 		for(Map.Entry<String, Pessoa> entry : Pessoa.mapaPessoa.entrySet()) {
//			relatorio = relatorio + entry.getValue() + "\n";
////			escritor("RelatorioPessoa", entry.getValue().toString());
//		}
// 		if(relatorio != leitor("RelatorioPessoa")) {
//		escritor("RelatorioPessoa", relatorio);		
// 		}
//		
//	}
//}
