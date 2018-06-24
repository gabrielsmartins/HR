package br.ifsp.edu.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.ifsp.edu.dao.AtestadoMedicoDAO;
import br.ifsp.edu.model.AtestadoMedico;

public class ConsultaAtestadoView extends JFrame {
	

	private static final long serialVersionUID = 1L;
	private JLabel lblMatricula;
	private JTextField txtMatricula;
	private JButton btnPesquisar;
	private JScrollPane scrollPane;
	private JTable table;
	private JPanel panel;

	
	
	public ConsultaAtestadoView() {
		this.initComponents();
	}
	
	public void initComponents() {
		this.setTitle("Consulta de Atestados");
		this.setSize(800, 500);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		this.lblMatricula = new JLabel("Matricula");
		this.txtMatricula = new JTextField();
		this.btnPesquisar = new JButton("Pesquisar");
		this.panel = new JPanel(new GridLayout(2, 1));
		JPanel panelPesquisa = new JPanel(new GridLayout(1, 3));
		panelPesquisa.add(lblMatricula);
		panelPesquisa.add(txtMatricula);
		panelPesquisa.add(btnPesquisar);
		this.carregaTabela();
		this.scrollPane = new JScrollPane(table);
		Container contentPane = this.getContentPane();
		this.panel.add(new JLabel("Consulta de Atestados"));
		this.panel.add(panelPesquisa);
		contentPane.add(this.panel,BorderLayout.PAGE_START);
		contentPane.add(this.scrollPane, BorderLayout.CENTER);
	}
	
	
	private void carregaTabela() {
		String columns [] = {"ID","Matricula","Nome","CID","Data Inicio","Qntd. Dias","CRM","Medico"};
		DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	   
		for(AtestadoMedico atestado : new AtestadoMedicoDAO().listar()) {
			Vector<String> row = new Vector<>();
			row.add(0, String.valueOf(atestado.getId()));
			row.add(1, String.valueOf(atestado.getFuncionario().getMatricula()));
			row.add(2, atestado.getFuncionario().getNome());
			row.add(3, atestado.getCid());
			row.add(4, atestado.getDataInicio().format(formatter));
			row.add(5, String.valueOf(atestado.getQuantidadeDias()));
			row.add(6, atestado.getCrm());
			row.add(7, atestado.getMedico());
			tableModel.addRow(row);
		}
		
		
 
		this.table = new JTable(tableModel);
		
		this.table.getColumnModel().getColumn(0).setPreferredWidth(20);
		this.table.getColumnModel().getColumn(1).setPreferredWidth(50);
		this.table.getColumnModel().getColumn(2).setPreferredWidth(150);
		this.table.getColumnModel().getColumn(3).setPreferredWidth(50);
		this.table.getColumnModel().getColumn(4).setPreferredWidth(50);
		this.table.getColumnModel().getColumn(5).setPreferredWidth(50);
		this.table.getColumnModel().getColumn(5).setPreferredWidth(50);
		this.table.getColumnModel().getColumn(6).setPreferredWidth(150);

	}

	public JButton getBtnPesquisar() {
		return btnPesquisar;
	}

	public JTextField getTxtMatricula() {
		return txtMatricula;
	}

	public JTable getTable() {
		return table;
	}


	
	

}
