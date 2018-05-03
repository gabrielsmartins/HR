package br.ifsp.edu.view;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import br.ifsp.edu.model.Funcionario;

public class MenuView extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JMenuBar menuBar;
	private JMenu menuPonto;
	private JMenuItem menuItemMarcarPonto;
	private JMenuItem menuItemRelatorioPonto;
	private JMenu menuAtestado;
	private JMenuItem menuItemRegistrarAtestado;
	

	
	
	private Funcionario funcionario;
	
	public MenuView(Funcionario funcionario) {
		this.funcionario = funcionario;
		this.initComponents();
		
	}
	
	
	private void initComponents() {
		this.setTitle("Menu");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
	
		this.menuBar = new JMenuBar();
		this.menuPonto = new JMenu("Ponto");
		this.menuAtestado = new JMenu("Atestados");
		this.menuItemMarcarPonto = new JMenuItem("Marcar Ponto");
		this.menuItemRelatorioPonto = new JMenuItem("Relatório Ponto");
		this.menuItemRegistrarAtestado = new JMenuItem("Registrar Atestado");
		
		menuPonto.add(menuItemMarcarPonto);
		menuBar.add(menuPonto);
		
		menuAtestado.add(menuItemRegistrarAtestado);
		

		if(this.funcionario.getPerfil().getDescricao().toUpperCase().equals("RH")) {
			menuPonto.add(menuItemRelatorioPonto);
			menuBar.add(menuAtestado);
		
		}
		
		Container pane = getContentPane();
		
		pane.add(menuBar, BorderLayout.PAGE_START);

		
	}




	public JMenu getMenuPonto() {	
		return menuPonto;
	}


	public JMenuItem getMenuItemMarcarPonto() {
		return menuItemMarcarPonto;
	}
	
	
	

}
