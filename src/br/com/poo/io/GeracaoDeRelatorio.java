package br.com.poo.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import br.com.poo.cargos.Funcionario;

public class GeracaoDeRelatorio {

    public static void main(String[] args) {
        // Obtém o mapa de outra classe (substitua o nome da classe e o método de obtenção do mapa)
        Map<String, Funcionario> mapa = Funcionario.GetmapaFuncionario();

        // Geração dos arquivos de texto
        for (String cargo : mapa.keySet()) {
            String nomeArquivo = cargo + ".txt";
            Funcionario conteudo = mapa.get(cargo);
            gerarArquivoTexto(nomeArquivo, conteudo);
            moverArquivoParaPasta(nomeArquivo, "Relatório");
        }

        System.out.println("Arquivos de texto gerados e movidos para a pasta Relatório com sucesso!");
    }

    public static void gerarArquivoTexto(String nomeArquivo, Funcionario funcionario) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo));
            writer.write(funcionario);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void moverArquivoParaPasta(String nomeArquivo, String nomePasta) {
        try {
            Path origem = Paths.get(nomeArquivo);
            Path destino = Paths.get(nomePasta, nomeArquivo);
            Files.createDirectories(destino.getParent());
            Files.move(origem, destino);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



