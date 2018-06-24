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
	private JMenuItem menuItemConsultarPonto;
	private JMenu menuAtestado;
	private JMenuItem menuItemRegistrarAtestado;
	private JMenuItem menuItemConsultarAtestado;
	

	
	
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
		this.menuItemConsultarPonto = new JMenuItem("Consulta Ponto");
		this.menuItemRegistrarAtestado = new JMenuItem("Registrar Atestado");
		this.menuItemConsultarAtestado = new JMenuItem("Consultar Atestado");
		
		menuPonto.add(menuItemMarcarPonto);
		menuBar.add(menuPonto);
		
		menuAtestado.add(menuItemRegistrarAtestado);
		menuAtestado.add(menuItemConsultarAtestado);
		

		if(this.funcionario.getPerfil().getDescricao().toUpperCase().equals("RH")) {
			menuPonto.add(menuItemConsultarPonto);
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


	public JMenuItem getMenuItemRegistrarAtestado() {
		return menuItemRegistrarAtestado;
	}


	public JMenuItem getMenuItemConsultarPonto() {
		return menuItemConsultarPonto;
	}


	public JMenuItem getMenuItemConsultarAtestado() {
		return menuItemConsultarAtestado;
	}
	
	
	
	
	
	

}
