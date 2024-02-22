package br.edu.senaisp.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import br.edu.senaisp.model.Funcionario;
import br.edu.senaisp.util.Log;

public class FuncionarioDao {

	private String pathBanco = "C:\\\\temp\\\\arquivo\\\\BancoDeDados.csv";

	public void gravarFuncionario(List<Funcionario> funcionarios) throws Exception  {
		
		// Escrita
		PrintWriter pw;
		try {
			pw = new PrintWriter(pathBanco, Charset.forName("UTF-8"));

			for (Funcionario f : funcionarios) {
				pw.print(f.getId());
				pw.print(";" + f.getNome());
				pw.print(";" + f.getCpf());
				pw.println();
			}

			pw.close();
		} catch (Exception e) {
			Log.escrever("Erro ao tentar gravar Funcionários: " + e.getMessage());
		}
	}
	
	public List<Funcionario> lerFuncionarios() {
		List<Funcionario> resposta = new ArrayList<Funcionario>();
		
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader(pathBanco));

			String linha;
			
			Funcionario temp;
			while ((linha = br.readLine()) != null) {

				String[] palavras = linha.split(";");
				temp = new Funcionario();
				temp.setId(Long.parseLong(palavras[0]));
				temp.setNome(palavras[1]);
				temp.setCpf(palavras[2]);
				
				resposta.add(temp);
			}

		} catch (Exception e) {
			Log.escrever("Erro lendo os funcionários: " + e.getMessage());	
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				Log.escrever(e.getMessage());	
			}
		}
		
		return resposta;
	}
	
}
