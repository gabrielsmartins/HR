package br.ifsp.edu.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.ifsp.edu.dao.AtestadoMedicoDAO;
import br.ifsp.edu.dao.FuncionarioDAO;
import br.ifsp.edu.model.AtestadoMedico;
import br.ifsp.edu.model.Funcionario;
import br.ifsp.edu.view.AtestadoView;
import br.ifsp.edu.view.ConsultaAtestadoView;

public class AtestadoController {
	
	private AtestadoView atestadoView = new AtestadoView();
	private ConsultaAtestadoView consultaAtestadoView = new ConsultaAtestadoView();
	private AtestadoMedicoDAO atestadoMedicoDAO = new AtestadoMedicoDAO();
	private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
	
	public AtestadoController() {
		this.loadListeners();
	}
	
	public void exibirRegistroAtestado() {
		this.atestadoView.setVisible(true);
	}
	
	public void exibirConsultaAtestado() {
		this.consultaAtestadoView.setVisible(true);
	}
	
	public void loadListeners() {
		
		
		this.atestadoView.getBtnPesquisar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		this.atestadoView.getBtnRegistrar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
				String crm = atestadoView.getTxtCRM().getText();
				String medico = atestadoView.getTxtMedico().getText();
				Long quantidadeDias = Long.parseLong(atestadoView.getTxtQuantidadeDias().getText());
				String data = atestadoView.getTxtDataInicio().getText();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate dataInicio = LocalDate.parse(data, formatter);
				String cid = atestadoView.getTxtCID().getText();
				
				if(crm == null || medico == null || quantidadeDias == null || data == null || dataInicio == null) {
					JOptionPane.showMessageDialog(null, "Por favor preencha todos os campos obrigatorios");
				}else {

					Funcionario funcionario = funcionarioDAO.pesquisar(Long.parseLong(atestadoView.getTxtMatricula().getText()));
					
					AtestadoMedico atestado = new AtestadoMedico(funcionario, cid, dataInicio, quantidadeDias, medico, crm);
					atestadoMedicoDAO.registrar(atestado);
					JOptionPane.showMessageDialog(null, "Atestado Registrado com Sucesso");
					
					atestadoView.getTxtMatricula().setText("");
					atestadoView.getLblNomeFuncionarioValue().setText("-");
					atestadoView.getTxtCID().setText("");
					atestadoView.getTxtCRM().setText("");
					atestadoView.getTxtDataInicio().setText("");
					atestadoView.getTxtMedico().setText("");
					atestadoView.getTxtQuantidadeDias().setText("");
					
				}
				
				
			}
		});
		
		
		this.atestadoView.getTxtMatricula().addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				String matricula = atestadoView.getTxtMatricula().getText();
				
				if(!matricula.isEmpty()) {
					Funcionario funcionario = funcionarioDAO.pesquisar(Long.parseLong(matricula));
					atestadoView.getLblNomeFuncionarioValue().setText(funcionario.getNome());
				}
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		this.consultaAtestadoView.getBtnPesquisar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
                String matricula = consultaAtestadoView.getTxtMatricula().getText();
                List<AtestadoMedico> atestados;
                
                if(!matricula.isEmpty()) {
                	  atestados = atestadoMedicoDAO.pesquisarPorMatricula(Long.parseLong(matricula));
                }else {
                      atestados = atestadoMedicoDAO.listar();
                }
               
                
                
                String columns [] = {"ID","Matricula","Nome","CID","Data Inicio","Qntd. Dias","CRM","Medico"};
        		DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
        		
        		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        	   
        		for(AtestadoMedico atestado : atestados) {
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
        		
        		consultaAtestadoView.getTable().setModel(tableModel);
        		
				
			}
		});
		
		
			}

}
