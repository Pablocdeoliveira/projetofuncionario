package br.edu.senaisp.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.edu.senaisp.model.Funcionario;

public class FuncionarioDetView extends JDialog{
	private Funcionario func = new Funcionario();
	
	JLabel lblId = new JLabel("Id:");
	JTextField txtId = new JTextField(null, 20);	
	JLabel lblNome = new JLabel("Nome:");
	JTextField txtNome = new JTextField(null, 20);
	JLabel lblCpf = new JLabel("Cpf:");
	JTextField txtCpf = new JTextField(null, 20);
	
	JButton btnGravar = new JButton("Gravar");
	JButton btnFechar = new JButton("Fechar");
	
	public FuncionarioDetView() {
		this.setLayout(new FlowLayout());
		
		this.lblId.setBounds(50, 30, 80, 20);
		this.txtId.setBounds(80, 30, 150, 30);
		
		this.lblNome.setBounds(50, 70, 80, 20);
		this.txtNome.setBounds(100, 70, 150, 30);
		
		this.lblCpf.setBounds(50, 110, 80, 20);
		this.txtCpf.setBounds(90, 110, 150, 30);
		
		this.getContentPane().add(lblId);
		this.getContentPane().add(txtId);
		
		this.getContentPane().add(lblNome);
		this.getContentPane().add(txtNome);
		
		this.getContentPane().add(lblCpf);
		this.getContentPane().add(txtCpf);
		
		this.getContentPane().add(btnGravar);
		this.getContentPane().add(btnFechar);
		
		btnGravar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				func.setId(Long.parseLong(txtId.getText()));
				func.setNome(txtNome.getText());
				func.setCpf(txtCpf.getText());
				
				hide();
				
			}
		
		});
		
		this.setSize(700, 450);
		this.setVisible(true);
	}

	public Funcionario getFunc() {
		return func;
	}

	public void setFunc(Funcionario func) {
		this.func = func;
	}
	
}
