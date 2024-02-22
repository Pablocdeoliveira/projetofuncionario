package br.edu.senaisp.controller;

import java.util.ArrayList;
import java.util.List;

import br.edu.senaisp.dao.FuncionarioDao;
import br.edu.senaisp.model.Funcionario;
import br.edu.senaisp.util.Log;
import br.edu.senaisp.view.FuncionarioView;

public class FuncionarioController {

	public static void main(String[] args) {
		
		FuncionarioView funcView = new FuncionarioView();
		
		Funcionario f1 = new Funcionario(123, "Rogério", "000.000.000-00");
		Funcionario f2 = new Funcionario(456, "Gojo", "111.111.111-11");
		Funcionario f3 = new Funcionario(789, "Uramaki", "222.222.222-22");
		
		List<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
		listaFuncionario.add(f1);
		listaFuncionario.add(f2);
		listaFuncionario.add(f3);
		
		FuncionarioDao dao = new FuncionarioDao();
		try {
			dao.gravarFuncionario(listaFuncionario);
			Log.escrever("Sucesso em gravar os funcionarios");
		} catch (Exception e) {
			Log.escrever("O erro: " + e);
		}
		
	}

}
