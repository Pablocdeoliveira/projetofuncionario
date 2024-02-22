package br.edu.senaisp.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import br.edu.senaisp.model.Aluno;
import br.edu.senaisp.util.Log;

public class AlunoController {
	private static String pathBancoDados = "C:\\Temp\\TestedeArquivo\\BancoDeDados.csv";

	public static void main(String[] args) {
 
		Aluno a1 = new Aluno(123L, "Josúe", "000.000.000-00");
 
		Aluno a2 = new Aluno();
		a2.setId(124L);
		a2.setNome("Juju");
		a2.setCpf("111.111.111-11");
 
		List<Aluno> lista = new ArrayList<Aluno>();
		lista.add(a1);
		lista.add(a2);
 
		PrintWriter pw;
 
		// Escrita
		try {
 
			pw = new PrintWriter("pathBancoDados", Charset.forName("UTF-8"));
 
			for (Aluno aluno : lista) {
				pw.print(aluno.getId());
				pw.print(";" + aluno.getNome());
				pw.print(";" + aluno.getCpf());
				pw.println();
			}
 
			pw.close();
			Log.escrever("Sucesso");
 
		} catch (Exception e) {
 
			Log.escrever("Erro: " + e.getMessage());
			System.out.println("Erro: " + e.getMessage());
		}
 
		// Leitura
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("pathBancoDados"));
 
			String linha;
			while ((linha = br.readLine()) != null) {
				System.out.println(linha);
			}
		} catch (Exception e) {
			Log.escrever(e.getMessage());
		} finally {
 
			try {
				br.close();
			} catch (IOException e) {
				Log.escrever("Nao conseguiu liberar o recurso. " + e.getMessage());
			}
		}
	}
}
