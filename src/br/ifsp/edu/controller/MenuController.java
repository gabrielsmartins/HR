package br.ifsp.edu.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.ifsp.edu.model.Funcionario;
import br.ifsp.edu.view.MenuView;

public class MenuController {

	private MenuView menuView;
	private Funcionario funcionario;
	
	
	public MenuController(Funcionario funcionario) {
		this.funcionario = funcionario;
		this.menuView = new MenuView(funcionario);
		this.loadListeners();
		this.menuView.setVisible(true);
	}

	
	private void loadListeners() {
		
		this.menuView.getMenuItemMarcarPonto().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FrequenciaController(funcionario);
				
			}
		});
		
		
	}
	
	
	
	
	
}
