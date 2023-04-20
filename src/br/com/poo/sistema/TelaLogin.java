package br.com.poo.sistema;

import java.awt.Container;

import javax.swing.*;
public class TelaLogin extends JFrame {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		TelaLogin field = new TelaLogin();
	     field.TelaLogin();

	}

	private void TelaLogin() {
		 Container janela = getContentPane();
         setLayout(null);

         
         JLabel labelCep = new JLabel("CEP: ");
         JLabel labelTel = new JLabel("Telefone: ");
         JLabel labelCpf = new JLabel("CPF: ");
         JLabel labelData = new JLabel("Data: ");
         labelCep.setBounds(50,40,100,20);
         labelTel.setBounds(50,80,100,20);
         labelCpf.setBounds(50,120,100,20);
         labelData.setBounds(50,160,100,20);
		
	}

}
