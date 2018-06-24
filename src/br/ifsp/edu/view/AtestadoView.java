package br.ifsp.edu.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AtestadoView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private JTextField txtMatricula;
	private JLabel lblMatricula;
	private JLabel lblNomeFuncionario;
	private JLabel lblNomeFuncionarioValue;
	
	private JLabel lblCID;
	private JLabel lblDataInicio;
	private JLabel lblQuantidadeDias;
	private JLabel lblMedico;
	private JLabel lblCRM;
	
	private JTextField txtCID;
	private JTextField txtDataInicio;
	private JTextField txtQuantidadeDias;
	private JTextField txtMedico;
	private JTextField txtCRM;
	
	
	private JButton btnPesquisar;
	private JButton btnRegistrar;
	private JPanel panel;
	
	
	public AtestadoView() {
		this.initComponents();
		
	}
	
	
	private void initComponents() {
		this.setTitle("Cadastro de Atestados");
		this.setSize(300, 300);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		
		this.btnPesquisar = new JButton("Pesquisar");
		this.btnRegistrar = new JButton("Salvar");
		
		this.lblMatricula = new JLabel("Matricula*");
		this.lblNomeFuncionario = new JLabel("Nome");
		this.lblNomeFuncionarioValue = new JLabel("-");
		this.lblCID = new JLabel("CID");
		this.lblCRM = new JLabel("CRM*");
		this.lblDataInicio = new JLabel("Data Inicio*");
		this.lblMedico = new JLabel("Medico*");
		this.lblQuantidadeDias = new JLabel("Quantidade Dias*");
		
		this.txtMatricula = new JTextField();
		this.txtCID = new JTextField();
		this.txtCRM = new JTextField();
		this.txtDataInicio = new JTextField();
		this.txtMedico = new JTextField();
		this.txtQuantidadeDias = new JTextField();
		
		this.panel = new JPanel(new GridLayout(8,2));
		this.panel.add(lblMatricula);
		this.panel.add(txtMatricula);
		this.panel.add(lblNomeFuncionario);
		this.panel.add(lblNomeFuncionarioValue);
		this.panel.add(lblMedico);
		this.panel.add(txtMedico);
		this.panel.add(lblCID);
		this.panel.add(txtCID);
		this.panel.add(lblCRM);
		this.panel.add(txtCRM);
		this.panel.add(lblDataInicio);
		this.panel.add(txtDataInicio);
		this.panel.add(lblQuantidadeDias);
		this.panel.add(txtQuantidadeDias);
		Container pane = getContentPane();
		pane.add(new JLabel("Registro de Atestado"), BorderLayout.PAGE_START);
		pane.add(panel,BorderLayout.CENTER);
		pane.add(this.btnRegistrar,BorderLayout.PAGE_END);

	}


	public JButton getBtnPesquisar() {
		return btnPesquisar;
	}


	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}


	public JTextField getTxtMatricula() {
		return txtMatricula;
	}


	public JLabel getLblNomeFuncionarioValue() {
		return lblNomeFuncionarioValue;
	}


	public JTextField getTxtCID() {
		return txtCID;
	}


	public JTextField getTxtDataInicio() {
		return txtDataInicio;
	}


	public JTextField getTxtQuantidadeDias() {
		return txtQuantidadeDias;
	}


	public JTextField getTxtMedico() {
		return txtMedico;
	}


	public JTextField getTxtCRM() {
		return txtCRM;
	}


	
	
	
	
	
	
	
	

}
