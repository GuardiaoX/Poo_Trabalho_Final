package br.com.poo.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class LeituraEscrita {
    static final String PATH_BASICO = "./temp/";
    static final String EXTENSAO = ".txt";

    public static void leitor(String path) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(PATH_BASICO + path + EXTENSAO));
        String linha = "";
        while (true) {
            linha = buffRead.readLine();
            if (linha != null) {
                System.out.println(linha);
            } else {
                break;
            }
        }
        buffRead.close();
    }

    public static void escritor() throws IOException {

        String nome = "oi";

        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nome + EXTENSAO, true));
        String linha = "";

        System.out.println("Escreva algo: ");
        linha = "oi";
        buffWrite.append(linha + "\n");
        buffWrite.close();

    }

    public static void main(String[] args) throws IOException {
        StringBuilder op = new StringBuilder();
        String Daniel = JOptionPane.showInputDialog("Qual teu nome amigo?");
        op.append("Bem vindo "+Daniel+"!");
//        JOptionPane.showinput
//        JOptionPane.showMessageDialog(null, op);
    }
}
