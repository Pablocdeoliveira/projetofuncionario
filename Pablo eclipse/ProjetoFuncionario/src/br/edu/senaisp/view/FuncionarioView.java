package br.edu.senaisp.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import br.edu.senaisp.dao.FuncionarioDao;
import br.edu.senaisp.model.Funcionario;

public class FuncionarioView extends JFrame{

	private JButton btnNovo = new JButton("Novo");
	private JLabel lblLista = new JLabel("Lista de Funcionários: ");
	private JTextArea txtLista = new JTextArea();
	
	private List<Funcionario> funcionarios = new ArrayList<Funcionario>();
	
	public FuncionarioView() {
		inicializar();
		acoes();
		
		FuncionarioDao dao = new 		FuncionarioDao();
		funcionarios = dao.lerFuncionarios();	
		
		preencherFuncionario();
	}
	
	private void inicializar() {
		this.setLayout(null);
		this.btnNovo.setBounds(50, 30, 150, 20);
		this.lblLista.setBounds(50, 70, 300, 20);
		this.txtLista.setBounds(50, 90, 500, 160);
		
		
		this.getContentPane().add(btnNovo);
		this.getContentPane().add(lblLista);
		this.getContentPane().add(txtLista);
		
		this.setSize(800, 600);
		this.setVisible(true);
		
	}
	
	public void acoes() {
		btnNovo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FuncionarioDetView funcDetView = new FuncionarioDetView();
				funcDetView.show();
				
				Funcionario temp = funcDetView.getFuncionario();
				funcionarios.add(temp);
				
				FuncionarioDao dao = new FuncionarioDao();
				try {
					dao.gravarFuncionario(funcionarios);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(funcDetView, e1.getMessage());
				}
				
				preencherFuncionario();
				
			}
		});
	}
	
	private void preencherFuncionario() {
		txtLista.setText("");
		for (Funcionario funcionario : funcionarios) {
			txtLista.append(funcionario.getNome() + " [" + funcionario.getCpf() + "] ");
			txtLista.append("\n");
		}
	}
	
}
