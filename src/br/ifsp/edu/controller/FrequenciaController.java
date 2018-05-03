package br.ifsp.edu.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.ifsp.edu.dao.FrequenciaDAO;
import br.ifsp.edu.model.Frequencia;
import br.ifsp.edu.model.Funcionario;
import br.ifsp.edu.view.PontoView;

public class FrequenciaController {
	
	private FrequenciaDAO frequenciaDAO = new FrequenciaDAO();
	private PontoView pontoView;
	private Funcionario funcionario;
	
	public FrequenciaController(Funcionario funcionario) {
		this.funcionario = funcionario;
		this.pontoView = new PontoView(funcionario);
		this.loadListeners();
		this.pontoView.setVisible(true);
	}
	
	private void loadListeners() {
		this.pontoView.getBtnMarcarPonto().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			    Frequencia frequencia = new Frequencia(funcionario);
				Frequencia freq = frequenciaDAO.registrar(frequencia);
				if(freq != null) {
					JOptionPane.showMessageDialog(null, "Ponto Registrado com Sucesso !!!");
					pontoView.getBtnMarcarPonto().setEnabled(false);
				}
			}
		});
	}
	
	
	
	

}
