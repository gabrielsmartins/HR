package br.ifsp.edu.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.ifsp.edu.model.Funcionario;
import br.ifsp.edu.model.Sessao;
import br.ifsp.edu.view.MenuView;

public class MenuController {

	private MenuView menuView;
	
	
	public MenuController() {
		Funcionario funcionario = Sessao.getInstance().getFuncionario();
		this.menuView = new MenuView(funcionario);
		this.loadListeners();
		this.menuView.setVisible(true);
	}

	
	private void loadListeners() {
		
		this.menuView.getMenuItemMarcarPonto().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FrequenciaController().exibirMarcacaoPonto();
				
			}
		});
		
this.menuView.getMenuItemConsultarPonto().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FrequenciaController().exibirConsultaPonto();
				
			}
		});
		
		
		this.menuView.getMenuItemRegistrarAtestado().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new AtestadoController().exibirRegistroAtestado();
			}
		});
		
		
		this.menuView.getMenuItemConsultarAtestado().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new AtestadoController().exibirConsultaAtestado();
			}
		});
		
	}
	
	
	
	
	
}
