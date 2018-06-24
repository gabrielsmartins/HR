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

import br.ifsp.edu.dao.FrequenciaDAO;
import br.ifsp.edu.model.Frequencia;

public class ConsultaPontoView extends JFrame {
	

	private static final long serialVersionUID = 1L;
	private JLabel lblMatricula;
	private JTextField txtMatricula;
	private JButton btnPesquisar;
	private JScrollPane scrollPane;
	private JTable table;
	private JPanel panel;

	
	
	public ConsultaPontoView() {
		this.initComponents();
	}
	
	public void initComponents() {
		this.setTitle("Consulta de Marcacoes de Ponto");
		this.setSize(500, 500);
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
		this.panel.add(new JLabel("Consulta de Marcacoes de Ponto"));
		this.panel.add(panelPesquisa);
		contentPane.add(this.panel,BorderLayout.PAGE_START);
		contentPane.add(this.scrollPane, BorderLayout.CENTER);
	}
	
	
	private void carregaTabela() {
		String columns [] = {"Ano","Mes","Matricula","Nome","Data"};
		DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy:hh:mm:ss");
	   
		for(Frequencia frequencia : new FrequenciaDAO().listar()) {
			Vector<String> row = new Vector<>();
			row.add(0, String.valueOf(frequencia.getDataHora().getYear()));
			row.add(1, String.valueOf(frequencia.getDataHora().getMonthValue()));
			row.add(2, String.valueOf(frequencia.getFuncionario().getMatricula()));
			row.add(3, frequencia.getFuncionario().getNome());
			row.add(4, frequencia.getDataHora().format(formatter));
			tableModel.addRow(row);
		}
		
		
 
		this.table = new JTable(tableModel);
		
		this.table.getColumnModel().getColumn(0).setPreferredWidth(20);
		this.table.getColumnModel().getColumn(1).setPreferredWidth(20);
		this.table.getColumnModel().getColumn(2).setPreferredWidth(50);
		this.table.getColumnModel().getColumn(3).setPreferredWidth(150);
		this.table.getColumnModel().getColumn(4).setPreferredWidth(50);

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
