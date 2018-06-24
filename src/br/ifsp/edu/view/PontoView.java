package br.ifsp.edu.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.ifsp.edu.model.Funcionario;

public class PontoView extends JFrame {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private JPanel panel;
	private JButton btnMarcarPonto;
	private JLabel lblMatricula;
	private JLabel lblNome;
	private JLabel lblCargo;
	private JLabel lblPerfil;
	private JTextField txtDataHora;
	private Funcionario funcionario;
	
	public PontoView(Funcionario funcionario) {
		this.funcionario = funcionario;
		this.initComponents();
	}
	
	
	private void initComponents() {
		this.setTitle("Marcação de Ponto");
		this.setSize(350, 200);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
	
		this.btnMarcarPonto = new JButton("Marcar Ponto");
		this.lblMatricula = new JLabel(String.valueOf(this.funcionario.getMatricula()));
		this.lblNome = new JLabel(this.funcionario.getNome());
		this.lblCargo = new JLabel(this.funcionario.getCargo());
		this.lblPerfil = new JLabel(this.funcionario.getPerfil().getDescricao());
		this.panel = new JPanel(new GridLayout(6, 2));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy:hh:mm:ss");
		this.txtDataHora = new JTextField(LocalDateTime.now().format(formatter ));
		Container pane = getContentPane();
		
		panel.add(new JLabel("Matricula:"));
		panel.add(lblMatricula);
		panel.add(new JLabel("Nome:"));
		panel.add(lblNome);
		panel.add(new JLabel("Cargo:"));
		panel.add(lblCargo);
		panel.add(new JLabel("Perfil:"));
		panel.add(lblPerfil);
		panel.add(new JLabel("Data/Hora:"));
		panel.add(txtDataHora);
		
		pane.add(new JLabel("Marcação de Ponto"), BorderLayout.PAGE_START);
		pane.add(panel,BorderLayout.CENTER);
		pane.add(btnMarcarPonto,BorderLayout.PAGE_END);

		
	}


	public JButton getBtnMarcarPonto() {
		return btnMarcarPonto;
	}


	public JTextField getTxtDataHora() {
		return txtDataHora;
	}
	
	
	
	
	
	
	

}
