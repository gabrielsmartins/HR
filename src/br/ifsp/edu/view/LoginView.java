package br.ifsp.edu.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginView extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton btnLogin;
	private JButton btnFechar;
	private JTextField txtLogin;
	private JPasswordField txtSenha;
	private JPanel panel;

	
	private void initComponents() {
		this.setTitle("Autenticação de Usuário");
		this.setSize(400, 150);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		this.btnLogin = new JButton("Login");
		this.btnFechar = new JButton("Sair");
		this.txtLogin = new JTextField();
		this.txtSenha = new JPasswordField();
		this.panel = new JPanel(new GridLayout(3, 2));
		
		
		Container pane = getContentPane();

	
		
		panel.add(new JLabel("Login:"));
		panel.add(this.txtLogin);
		panel.add(new JLabel("Senha:"));
		panel.add(this.txtSenha);
		pane.add(new JLabel("Autenticação de Usuário"),BorderLayout.PAGE_START);
		pane.add(panel, BorderLayout.CENTER);
		panel.add(this.btnLogin,BorderLayout.PAGE_END);
		panel.add(this.btnFechar,BorderLayout.PAGE_END);
		
	}
	
	
	public LoginView() {
		this.initComponents();
	}


	public JButton getBtnLogin() {
		return btnLogin;
	}


	public JButton getBtnFechar() {
		return btnFechar;
	}


	public JTextField getTxtLogin() {
		return txtLogin;
	}


	public JPasswordField getTxtSenha() {
		return txtSenha;
	}



	


}
