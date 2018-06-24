package br.ifsp.edu.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.ifsp.edu.dao.FrequenciaDAO;
import br.ifsp.edu.model.Frequencia;
import br.ifsp.edu.model.Funcionario;
import br.ifsp.edu.model.Sessao;
import br.ifsp.edu.view.ConsultaPontoView;
import br.ifsp.edu.view.PontoView;

public class FrequenciaController {
	
	private FrequenciaDAO frequenciaDAO = new FrequenciaDAO();
	private PontoView pontoView;
	private ConsultaPontoView consultaPontoView;

	
	public FrequenciaController() {
		Funcionario funcionario = Sessao.getInstance().getFuncionario();
		this.pontoView = new PontoView(funcionario);
		this.consultaPontoView = new ConsultaPontoView();
		this.loadListeners();
	}
	
	public void exibirMarcacaoPonto() {
		this.pontoView.setVisible(true);
	}
	
	public void exibirConsultaPonto() {

	this.consultaPontoView.setVisible(true);
	}
	
	private void loadListeners() {
		
		
		this.pontoView.getBtnMarcarPonto().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Funcionario funcionario = Sessao.getInstance().getFuncionario();
			    Frequencia frequencia = new Frequencia(funcionario);
				Frequencia freq = frequenciaDAO.registrar(frequencia);
				if(freq != null) {
					JOptionPane.showMessageDialog(null, "Ponto Registrado com Sucesso !!!");
					pontoView.getBtnMarcarPonto().setEnabled(false);
				}
			}
		});
		
		
		this.consultaPontoView.getBtnPesquisar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String matricula = consultaPontoView.getTxtMatricula().getText();
				
				List<Frequencia> frequencias;
				if(!matricula.isEmpty()) {
					 frequencias = frequenciaDAO.pesquisarPorMatricula(Long.parseLong(matricula));
				}else {
					 frequencias = frequenciaDAO.listar();
				}
				
			
				String columns [] = {"Ano","Mes","Matricula","Nome","Data"};
				DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy:hh:mm:ss");
			   
				for(Frequencia frequencia : frequencias) {
					Vector<String> row = new Vector<>();
					row.add(0, String.valueOf(frequencia.getDataHora().getYear()));
					row.add(1, String.valueOf(frequencia.getDataHora().getMonthValue()));
					row.add(2, String.valueOf(frequencia.getFuncionario().getMatricula()));
					row.add(3, frequencia.getFuncionario().getNome());
					row.add(4, frequencia.getDataHora().format(formatter));
					tableModel.addRow(row);
				}
				
				consultaPontoView.getTable().setModel(tableModel);
				
			}
		});
	}
	
	
	
	

}
